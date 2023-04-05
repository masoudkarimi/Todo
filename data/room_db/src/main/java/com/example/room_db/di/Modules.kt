package com.example.room_db.di

import android.content.Context
import androidx.room.Room
import com.example.room_db.RoomDatabaseComponent
import com.example.room_db.TodoRoomDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import mkn.todo.db.TodoDatabase
import mkn.todo.db.dao.CategoryDao
import mkn.todo.db.dao.TaskDao

@Module
object RoomDatabaseModule {
    @DatabaseScope
    @Provides
    fun provideTodoRoomDatabase(context: Context): TodoRoomDatabase {
        return Room.databaseBuilder(context, TodoRoomDatabase::class.java, "todos.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}

@Module
object DatabaseDaoModule {
    @Provides
    fun provideCategoryDao(todoDatabase: TodoDatabase) : CategoryDao = todoDatabase.categoryDao()

    @Provides
    fun provideTaskDao(todoDatabase: TodoDatabase) : TaskDao = todoDatabase.taskDao()
}

@Module
abstract class RoomDatabaseBinds {
    @Binds
    abstract fun bindTodoDatabase(roomDatabase: TodoRoomDatabase): TodoDatabase
}

@Module(subcomponents = [RoomDatabaseComponent::class])
class DatabaseSubcomponentsModule {}