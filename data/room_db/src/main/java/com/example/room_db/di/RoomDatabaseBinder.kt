package com.example.room_db.di

import com.example.room_db.TodoRoomDatabase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mkn.todo.db.TodoDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RoomDatabaseBinder {

    @Binds
    @Singleton
    abstract fun bindTodoDatabase(roomDatabase: TodoRoomDatabase): TodoDatabase

}