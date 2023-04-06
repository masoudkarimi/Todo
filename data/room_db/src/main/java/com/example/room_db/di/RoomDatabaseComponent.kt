package com.example.room_db.di

import dagger.Subcomponent
import mkn.todo.db.dao.CategoryDao
import mkn.todo.db.dao.TaskDao

@Subcomponent(
    modules = [RoomDatabaseModule::class, DatabaseDaoModule::class, RoomDatabaseBinds::class]
)
@DatabaseScope
interface RoomDatabaseComponent {

    fun provideTaskDao(): TaskDao
    fun provideCategoryDao(): CategoryDao

    @Subcomponent.Factory
    interface Factory {
        fun create(): RoomDatabaseComponent
    }
}

