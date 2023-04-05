package mkn.todo.tasks.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import mkn.todo.tasks.domain.usecase.GetAllTasksUseCase
import javax.inject.Inject

class TodoListViewModel @Inject constructor(
    private val getAllTasksUseCase: GetAllTasksUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(TasksListState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getAllTasksUseCase()
                .catch {
                    it.printStackTrace()
                    _uiState.update { TasksListState(isLoading = false, isError = true) }
                }
                .onStart {
                    _uiState.update { it.copy(isLoading = true) }
                }
                .collectLatest { tasks ->
                    _uiState.update { it.copy(isLoading = false, tasks = tasks) }
                }
        }
    }
}