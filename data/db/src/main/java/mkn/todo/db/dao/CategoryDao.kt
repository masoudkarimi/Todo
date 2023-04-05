package mkn.todo.db.dao

import kotlinx.coroutines.flow.Flow
import mkn.todo.db.model.Category

interface CategoryDao {
    fun getAllCategories(): Flow<List<Category>>
    suspend fun addNewCategory(category: Category): Long
    suspend fun updateCategory(category: Category)
    suspend fun deleteCategory(category: Category)
}