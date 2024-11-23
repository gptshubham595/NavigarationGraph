package com.oops.navigarationgraph.core.inside.domain.repositories

import com.oops.navigarationgraph.commons.Either
import com.oops.navigarationgraph.commons.IFailure
import com.oops.navigarationgraph.core.inside.domain.models.TodoItem
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun getTodoList(): Either<IFailure, Flow<List<TodoItem>>>

    suspend fun addTodoItem(todoItem: TodoItem): Either<IFailure, Flow<Long>>

    suspend fun deleteTodoItem(todoId: Long): Either<IFailure, Flow<Int>>

    suspend fun updateTodoItem(todoItem: TodoItem): Either<IFailure, Flow<Int>>
}
