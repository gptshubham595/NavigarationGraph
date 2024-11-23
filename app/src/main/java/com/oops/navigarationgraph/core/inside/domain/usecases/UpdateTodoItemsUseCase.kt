package com.oops.navigarationgraph.core.inside.domain.usecases

import android.util.Log
import com.oops.navigarationgraph.commons.BaseUseCase
import com.oops.navigarationgraph.commons.Either
import com.oops.navigarationgraph.commons.IFailure
import com.oops.navigarationgraph.core.inside.domain.models.TodoItem
import com.oops.navigarationgraph.core.inside.domain.repositories.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpdateTodoItemsUseCase @Inject constructor(
    private val todoRepository: TodoRepository
) : BaseUseCase<TodoItem, Flow<Int>> {
    override suspend fun run(params: TodoItem): Either<IFailure, Flow<Int>> {
        Log.d("GetTodoItemsUseCase", "run: ${System.identityHashCode(this)}")
        return todoRepository.updateTodoItem(params)
    }
}
