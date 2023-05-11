package mkn.todo.tasks.domain

import kotlinx.coroutines.flow.Flow
import mkn.todo.data.model.Task

interface TasksRepository {
    fun getAllTasks(): Flow<List<Task>>
}