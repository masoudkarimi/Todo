package com.example.room_db

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import mkn.todo.db.TodoDatabase
import mkn.todo.db.dao.CategoryDao
import mkn.todo.db.dao.TaskDao
import javax.inject.Singleton

@Component(
    dependencies = [RoomDatabaseDependencies::class],
    modules = [RoomDatabaseModule::class, DatabaseDaoModule::class, RoomDatabaseBinds::class]
)
@Singleton
interface RoomDatabaseComponent {

    fun provideTodoDatabase(): TodoDatabase

    @Component.Factory
    interface Factory {
        fun databaseDependencies(dbDependencies: RoomDatabaseDependencies): RoomDatabaseComponent
    }
}

@Module
object RoomDatabaseModule {
    @Singleton
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