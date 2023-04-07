package mkn.todo.tasks.data.repo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import mkn.todo.base.android.utils.AppCoroutineDispatchers
import mkn.todo.db.dao.TaskDao
import mkn.todo.tasks.domain.TasksRepository
import mkn.todo.tasks.domain.model.Category
import mkn.todo.tasks.domain.model.Task
import javax.inject.Inject

class TasksRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao,
    private val dispatchers: AppCoroutineDispatchers
) : TasksRepository {

    override fun getAllTasks(): Flow<List<Task>> {
        return taskDao.getAllTasks()
            .map { tasks ->
                tasks.filter {
                    it.task != null && it.category != null
                }.map { taskWithCategory ->
                    Task(
                        id = taskWithCategory.task!!.id,
                        category = Category(
                            id = taskWithCategory.category!!.id,
                            name = taskWithCategory.category!!.name
                        ),
                        title = taskWithCategory.task!!.title,
                        description = taskWithCategory.task!!.description,
                    )
                }
            }
            .flowOn(dispatchers.io)
    }
}