package com.oops.navigarationgraph.core.di.module

import android.app.Application
import androidx.room.Room
import com.oops.navigarationgraph.commons.APIConstants
import com.oops.navigarationgraph.commons.TODO_DB_NAME
import com.oops.navigarationgraph.core.di.qualifier.RetrofitAPIQualifier
import com.oops.navigarationgraph.core.di.qualifier.RoomDatabaseQualifier
import com.oops.navigarationgraph.core.inside.data.datasource.TodoDataSource
import com.oops.navigarationgraph.core.interfaces.datasourceImpl.db.database.RoomTodoDataBase
import com.oops.navigarationgraph.core.interfaces.datasourceImpl.network.APIServiceTodoDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    @RoomDatabaseQualifier
    fun provideTodoRoomDao(todoRoomDatabase: RoomTodoDataBase): TodoDataSource {
        return todoRoomDatabase.getTodoDao()
    }

    @Provides
    @Singleton
    fun provideRoomTodoDataBase(application: Application): RoomTodoDataBase {
        return Room.databaseBuilder(application, RoomTodoDataBase::class.java, TODO_DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    @RetrofitAPIQualifier
    fun provideApiInterface(
        interceptor: HttpLoggingInterceptor,
    ): APIServiceTodoDataSourceImpl {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder().baseUrl(APIConstants.POSTS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(
            APIServiceTodoDataSourceImpl::class.java
        )
    }

}
