package mkn.todo.tasks.data.di

import dagger.Binds
import dagger.Module
import mkn.todo.tasks.data.repo.TasksRepositoryImpl
import mkn.todo.tasks.domain.TasksRepository

@Module
internal abstract class TasksDataBinds {
    @Binds
    abstract fun bindRepository(tasksRepositoryImpl: TasksRepositoryImpl): TasksRepository
}