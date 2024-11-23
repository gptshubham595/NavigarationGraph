package com.oops.navigarationgraph.core.transformer;

import com.oops.navigarationgraph.core.inside.data.models.TodoItemEntity
import com.oops.navigarationgraph.core.inside.data.models.TodoStatus
import com.oops.navigarationgraph.core.inside.domain.models.TodoItem

fun TodoItemEntity?.toDomain(): TodoItem {
    return TodoItem(
        id = this?.id ?: 0,
        task = this?.task ?: "",
        status = TodoStatus.find(this?.status)
    )
}

fun TodoItem.toData(): TodoItemEntity {
    return TodoItemEntity(
        id = this.id,
        task = this.task,
        status = this.status.name
    )
}
