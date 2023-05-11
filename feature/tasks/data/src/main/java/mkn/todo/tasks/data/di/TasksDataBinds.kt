package mkn.todo.tasks.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import mkn.todo.tasks.data.repo.TasksRepositoryImpl
import mkn.todo.tasks.domain.TasksRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class TasksDataBinds {
    @Binds
    abstract fun bindRepository(tasksRepositoryImpl: TasksRepositoryImpl): TasksRepository
}