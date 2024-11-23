package com.oops.navigarationgraph.core.interfaces.datasourceImpl.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oops.navigarationgraph.core.inside.data.models.TodoItemEntity
import com.oops.navigarationgraph.core.interfaces.datasourceImpl.db.DBTodoDataSourceDao

@Database(entities = [TodoItemEntity::class], version = 1)
abstract class RoomTodoDataBase : RoomDatabase() {
    abstract fun getTodoDao(): DBTodoDataSourceDao
}