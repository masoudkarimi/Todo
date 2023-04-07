package com.example.room_db.di

import mkn.todo.db.dao.CategoryDao
import mkn.todo.db.dao.TaskDao

interface DatabaseComponent {
    fun provideTaskDao(): TaskDao
    fun provideCategoryDao(): CategoryDao
}