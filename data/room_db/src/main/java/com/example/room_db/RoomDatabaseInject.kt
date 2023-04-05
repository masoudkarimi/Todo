package com.example.room_db

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import mkn.todo.db.TodoDatabase
import javax.inject.Singleton

@Component(
    dependencies = [RoomDatabaseDependencies::class],
    modules = [RoomDatabaseModule::class, RoomDatabaseBinds::class]
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
abstract class RoomDatabaseBinds {
    @Binds
    abstract fun bindTodoDatabase(roomDatabase: TodoRoomDatabase): TodoDatabase
}