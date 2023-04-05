package com.example.room_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.room_db.dao.RoomCategoryDao
import com.example.room_db.dao.RoomTaskDao
import mkn.todo.db.TodoDatabase
import mkn.todo.db.model.Category
import mkn.todo.db.model.Task

@Database(
    entities = [
        Category::class,
        Task::class
    ],
    version = 1,
)
abstract class TodoRoomDatabase: RoomDatabase(), TodoDatabase {
    abstract override fun taskDao(): RoomTaskDao
    abstract override fun categoryDao(): RoomCategoryDao
}