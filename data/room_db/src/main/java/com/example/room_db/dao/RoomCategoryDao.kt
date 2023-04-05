package com.example.room_db.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import mkn.todo.db.dao.CategoryDao
import mkn.todo.db.model.Category

@Dao
abstract class RoomCategoryDao: CategoryDao {

    @Query("SELECT * FROM categories")
    abstract override fun getAllCategories(): Flow<List<Category>>

    @Insert
    abstract override suspend fun addNewCategory(category: Category): Long

    @Update
    abstract override suspend fun updateCategory(category: Category)

    @Delete
    abstract override suspend fun deleteCategory(category: Category)
}