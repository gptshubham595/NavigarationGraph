package com.oops.navigarationgraph.core.di.module

import com.google.gson.Gson
import com.oops.navigarationgraph.core.di.qualifier.RetrofitAPIQualifier
import com.oops.navigarationgraph.core.di.qualifier.RoomDatabaseQualifier
import com.oops.navigarationgraph.core.inside.data.datasource.TodoDataSource
import com.oops.navigarationgraph.core.inside.domain.repositories.TodoRepository
import com.oops.navigarationgraph.core.interfaces.repoImpl.TodoRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(
        @RoomDatabaseQualifier todoDao: TodoDataSource,
        @RetrofitAPIQualifier apiService: TodoDataSource
    ):
            TodoRepository {
        return TodoRepoImpl(todoDao, apiService)
    }
}
