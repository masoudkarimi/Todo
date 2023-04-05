package mkn.todo.tasks.data.di

import dagger.Component
import mkn.todo.db.dao.TaskDao
import mkn.todo.tasks.domain.TasksRepository

@Component(
    dependencies = [TasksDataDependencies::class],
    modules = [TasksDataBinds::class]
)
interface TasksDataComponent {

    fun provideRepository(): TasksRepository

    @Component.Factory
    interface Factory {
        fun tasksDataDependencies(tasksDataDependencies: TasksDataDependencies): TasksDataComponent
    }
}

interface TasksDataDependencies {
    fun provideTasksDao(): TaskDao
}