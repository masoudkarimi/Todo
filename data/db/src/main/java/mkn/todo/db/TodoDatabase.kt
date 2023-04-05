package mkn.todo.db

import mkn.todo.db.dao.CategoryDao
import mkn.todo.db.dao.TaskDao

interface TodoDatabase {
    fun taskDao(): TaskDao
    fun categoryDao(): CategoryDao
}