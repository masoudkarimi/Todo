package mkn.todo.tasks.domain

import kotlinx.coroutines.flow.Flow
import mkn.todo.tasks.domain.model.Task

interface TasksRepository {
    fun getAllTasks(): Flow<List<Task>>
}