package com.example.room_db.di

import android.content.Context
import androidx.room.Room
import com.example.room_db.TodoRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mkn.todo.db.TodoDatabase
import mkn.todo.db.dao.CategoryDao
import mkn.todo.db.dao.TaskDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDatabaseModule {

    @Provides
    @Singleton
    fun provideTodoRoomDatabase(@ApplicationContext context: Context): TodoRoomDatabase {
        return Room.databaseBuilder(context, TodoRoomDatabase::class.java, "todos.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideCategoryDao(todoDatabase: TodoDatabase) : CategoryDao = todoDatabase.categoryDao()

    @Provides
    fun provideTaskDao(todoDatabase: TodoDatabase) : TaskDao = todoDatabase.taskDao()
}

