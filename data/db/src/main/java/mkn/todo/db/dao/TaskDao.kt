package mkn.todo.db.dao

import kotlinx.coroutines.flow.Flow
import mkn.todo.db.model.Task

interface TaskDao {
    fun getAllCategories(): Flow<List<Task>>
    suspend fun addNewTask(task: Task): Long
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(task: Task)
}