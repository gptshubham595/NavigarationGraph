package com.oops.navigarationgraph.core.interfaces.datasourceImpl.network

import com.oops.navigarationgraph.commons.APIConstants
import com.oops.navigarationgraph.core.inside.data.datasource.TodoDataSource
import com.oops.navigarationgraph.core.inside.data.models.TodoItemEntity
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface APIServiceTodoDataSourceImpl : TodoDataSource {

    @GET(APIConstants.GET_ALL_POSTS_ENDPOINT)
    override suspend fun fetchAllTodoItems(): List<TodoItemEntity>

    @POST(APIConstants.ADD_POSTS_ENDPOINT)
    override suspend fun addTodoItem(todoItemEntity: TodoItemEntity): Long

    @DELETE(APIConstants.DELETE_POST_ENDPOINT)
    override suspend fun deleteTodoItem(todoId: Long): Int

    @PUT(APIConstants.UPDATE_POST_ENDPOINT)
    override suspend fun updateTodoItem(todoItemEntity: TodoItemEntity): Int

//    @GET(APIConstants.GET_POST_BY_ID_ENDPOINT)
//    override suspend fun fetchIdTodoItem(todoId: Int): TodoItemEntity?
}