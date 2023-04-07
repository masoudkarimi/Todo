package mkn.todo.tasks.ui.di

import dagger.Subcomponent
import mkn.todo.tasks.data.di.TasksDataBinds
import mkn.todo.tasks.ui.TodoListFragment
import mkn.todo.tasks.ui.TodoSecondFragment

@Subcomponent(
    modules = [Binder::class, TasksDataBinds::class]
)
interface TasksUiComponent {
    fun inject(fragment: TodoListFragment)
    fun inject(fragment: TodoSecondFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TasksUiComponent
    }
}

interface TaskUiComponentFactoryProvider {
    fun providerTaskUiComponentFactory(): TasksUiComponent.Factory
}