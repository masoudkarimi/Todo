package mkn.todo.db.dao

import kotlinx.coroutines.flow.Flow
import mkn.todo.db.model.Task
import mkn.todo.db.model.TaskWithCategory

interface TaskDao {
    fun getAllTasks(): Flow<List<TaskWithCategory>>
    fun findTaskById(id: Long): TaskWithCategory?
    suspend fun addNewTask(task: Task): Long
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(task: Task)
}