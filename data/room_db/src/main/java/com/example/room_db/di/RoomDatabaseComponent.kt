package com.example.room_db

import com.example.room_db.di.DatabaseDaoModule
import com.example.room_db.di.DatabaseScope
import com.example.room_db.di.RoomDatabaseBinds
import com.example.room_db.di.RoomDatabaseModule
import dagger.Component
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

