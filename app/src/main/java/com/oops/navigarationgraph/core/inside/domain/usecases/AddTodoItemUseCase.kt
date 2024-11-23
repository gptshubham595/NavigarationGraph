package com.oops.navigarationgraph.core.inside.domain.usecases

import com.oops.navigarationgraph.commons.BaseUseCase
import com.oops.navigarationgraph.commons.Either
import com.oops.navigarationgraph.commons.IFailure
import com.oops.navigarationgraph.core.inside.domain.models.TodoItem
import com.oops.navigarationgraph.core.inside.domain.repositories.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddTodoItemUseCase @Inject constructor(
    private val todoRepository: TodoRepository
) : BaseUseCase<TodoItem, Flow<Long>> {
    override suspend fun run(params: TodoItem): Either<IFailure, Flow<Long>> {
        return todoRepository.addTodoItem(params)
    }
}
