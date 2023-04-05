package mkn.todo.tasks.ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.multibindings.IntoMap
import mkn.todo.tasks.ui.TodoListViewModel

@dagger.Module
abstract class Binder {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TodoListViewModel::class)
    abstract fun bindTopUpViewModel(todoListViewModel: TodoListViewModel): ViewModel
}