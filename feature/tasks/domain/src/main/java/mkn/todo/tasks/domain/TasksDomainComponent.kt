package mkn.todo.tasks.domain

import dagger.Component
import mkn.todo.tasks.domain.usecase.GetAllTasksUseCase

@Component(
    dependencies = [TasksDomainDependencies::class]
)
interface TasksDomainComponent {

    fun provideTasksUseCase(): GetAllTasksUseCase

    @Component.Factory
    interface Factory {
        fun domainDependencies(tasksDomainDependencies: TasksDomainDependencies): TasksDomainComponent
    }
}

interface TasksDomainDependencies {
    fun provideRepository(): TasksRepository
}