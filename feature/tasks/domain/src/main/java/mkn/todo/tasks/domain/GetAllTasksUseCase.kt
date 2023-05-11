package mkn.todo.tasks.domain

import kotlinx.coroutines.flow.Flow
import mkn.todo.data.model.Task
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(
    private val tasksRepository: TasksRepository
) {

    operator fun invoke(): Flow<List<Task>> {
        return tasksRepository.getAllTasks()
    }
}