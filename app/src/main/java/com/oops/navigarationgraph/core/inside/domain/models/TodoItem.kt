package com.oops.navigarationgraph.core.inside.domain.models

import com.oops.navigarationgraph.core.inside.data.models.TodoStatus

data class TodoItem(
    val id: Long,
    val task: String,
    val status: TodoStatus
)
