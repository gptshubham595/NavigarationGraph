package com.oops.navigarationgraph.core.inside.data.models

enum class TodoStatus {
    PENDING,
    COMPLETED;

    companion object {
        fun find(value: String?): TodoStatus {
            return entries.find { it.name.equals(value) } ?: PENDING
        }
    }
}