package com.example.room_db.di

import com.example.room_db.TodoRoomDatabase
import dagger.Binds
import dagger.Module
import mkn.todo.db.TodoDatabase

@Module
abstract class RoomDatabaseBinder {

    @Binds
    abstract fun bindTodoDatabase(roomDatabase: TodoRoomDatabase): TodoDatabase

}