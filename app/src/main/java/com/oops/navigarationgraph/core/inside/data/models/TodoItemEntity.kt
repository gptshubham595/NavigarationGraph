package com.oops.navigarationgraph.core.inside.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.oops.navigarationgraph.commons.PENDING
import com.oops.navigarationgraph.commons.TODO_COLUMN_STATUS_NAME
import com.oops.navigarationgraph.commons.TODO_COLUMN_TASK_NAME
import com.oops.navigarationgraph.commons.TODO_TABLE_NAME

@Entity(tableName = TODO_TABLE_NAME)
data class TodoItemEntity(
    @PrimaryKey
    @SerializedName("id")
    val id: Long,

    @ColumnInfo(name = TODO_COLUMN_TASK_NAME)
    @SerializedName("title")
    val task: String,

    @ColumnInfo(name = TODO_COLUMN_STATUS_NAME, defaultValue = PENDING)
    @SerializedName("status")
    val status: String = TodoStatus.PENDING.name
)