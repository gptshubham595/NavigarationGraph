package com.oops.navigarationgraph.core.interfaces.datasourceImpl.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.oops.navigarationgraph.core.inside.data.datasource.TodoDataSource
import com.oops.navigarationgraph.core.inside.data.models.TodoItemEntity

@Dao
interface DBTodoDataSourceDao : TodoDataSource {

    @Query("Select * from TODO_TABLE")
    override suspend fun fetchAllTodoItems(): List<TodoItemEntity>

    @Query("Select * from TODO_TABLE where id = :todoId")
    override suspend fun fetchIdTodoItem(todoId: Int): TodoItemEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun addTodoItem(todoItemEntity: TodoItemEntity): Long

    @Query("Delete from TODO_TABLE where id = :todoId")
    override suspend fun deleteTodoItem(todoId: Long): Int

    @Update
    override suspend fun updateTodoItem(todoItemEntity: TodoItemEntity): Int
}