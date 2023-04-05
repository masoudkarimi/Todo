package mkn.todo.tasks.domain.usecase

import kotlinx.coroutines.flow.Flow
import mkn.todo.tasks.domain.TasksRepository
import mkn.todo.tasks.domain.model.Task
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(
    private val tasksRepository: TasksRepository
) {

    operator fun invoke(): Flow<List<Task>> {
        return tasksRepository.getAllTasks()
    }
}