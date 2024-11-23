package com.oops.navigarationgraph.core.interfaces.repoImpl

import android.util.Log
import com.oops.navigarationgraph.commons.Either
import com.oops.navigarationgraph.commons.Failure
import com.oops.navigarationgraph.commons.IFailure
import com.oops.navigarationgraph.commons.Logger
import com.oops.navigarationgraph.core.di.qualifier.RetrofitAPIQualifier
import com.oops.navigarationgraph.core.di.qualifier.RoomDatabaseQualifier
import com.oops.navigarationgraph.core.inside.data.datasource.TodoDataSource
import com.oops.navigarationgraph.core.inside.domain.models.TodoItem
import com.oops.navigarationgraph.core.inside.domain.repositories.TodoRepository
import com.oops.navigarationgraph.core.transformer.toData
import com.oops.navigarationgraph.core.transformer.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import javax.inject.Inject

class TodoRepoImpl @Inject constructor(
    @RoomDatabaseQualifier private val todoDBDao: TodoDataSource, // IDatabase
    @RetrofitAPIQualifier private val todoAPI: TodoDataSource, // IDatabase
) : TodoRepository {
    override suspend fun getTodoList(): Either<IFailure, Flow<List<TodoItem>>> {
        return try {
            val dataFlow = flow {
                Log.d("ResponseDB", "${todoDBDao.fetchAllTodoItems().map { it.toDomain() }}")
                emit(todoDBDao.fetchAllTodoItems().map { it.toDomain() })
            }.catch { e ->
            }.flowOn(Dispatchers.IO).onCompletion {
                Logger.d("ResponseDB", "onCompletion")
            }

            val apiFlow = flow {
                val apiResponse: List<TodoItem> = todoAPI.fetchAllTodoItems().map { it.toDomain() }
                Log.d("ResponseAPI", "$apiResponse")

                apiResponse.let {
                    saveToDB(apiResponse)
                    emit(apiResponse)
                }
            }.flowOn(Dispatchers.IO)

            Either.Success(dataFlow.combine(apiFlow) { data, apiData -> data + apiData })
        } catch (e: Exception) {
            Either.Error(Failure.GenericException(exception = e))
        }
    }

    private suspend fun saveToDB(apiResponse: List<TodoItem>) {
        apiResponse.forEach {
            todoDBDao.addTodoItem(it.toData())
        }
    }

    override suspend fun addTodoItem(todoItem: TodoItem): Either<IFailure, Flow<Long>> {
        return try {
            Either.Success(
                flow {
                    emit(todoDBDao.addTodoItem(todoItem.toData()))
                }.flowOn(Dispatchers.IO)
            )
        } catch (e: Exception) {
            Either.Error(Failure.IOException(e))
        }
    }

    override suspend fun deleteTodoItem(todoId: Long): Either<IFailure, Flow<Int>> {
        return try {
            Either.Success(flow { emit(todoDBDao.deleteTodoItem(todoId)) }.flowOn(Dispatchers.IO))
        } catch (e: Exception) {
            Either.Error(Failure.IOException(e))
        }
    }

    override suspend fun updateTodoItem(todoItem: TodoItem): Either<IFailure, Flow<Int>> {
        return try {
            Either.Success(
                flow { emit(todoDBDao.updateTodoItem(todoItem.toData())) }.flowOn(
                    Dispatchers.IO
                )
            )
        } catch (e: Exception) {
            Either.Error(Failure.IOException(e))
        }
    }
}