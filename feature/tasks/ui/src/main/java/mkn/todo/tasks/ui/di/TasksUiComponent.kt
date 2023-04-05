package mkn.todo.tasks.ui.di

import dagger.Component
import mkn.todo.tasks.data.di.TasksDataComponent
import mkn.todo.tasks.ui.TodoListFragment

@Component(
    dependencies = [TasksDataComponent::class],
    modules = [Binder::class]
)
interface TasksUiComponent {
    fun inject(fragment: TodoListFragment)


    @Component.Factory
    interface Factory {
         fun dataDependency(todoDataComponent: TasksDataComponent): TasksUiComponent
    }
}