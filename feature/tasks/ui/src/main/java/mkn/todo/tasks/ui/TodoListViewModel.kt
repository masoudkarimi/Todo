package mkn.todo.tasks.ui

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import mkn.todo.data.model.Category
import mkn.todo.data.model.Task
import mkn.todo.tasks.domain.GetAllTasksUseCase
import javax.inject.Inject

@HiltViewModel
internal class TodoListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getAllTasksUseCase: GetAllTasksUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(TasksListState())
    val uiState = _uiState.asStateFlow()

    init {
        Log.d("DEBUG_DAGGER", "TodoListViewModel initiated")

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

    fun addNewTask() {
        _uiState.update {
            it.copy(tasks = it.tasks + listOf(
                Task(
                    id = it.tasks.size + 1L,
                    category = Category(
                        id = 0,
                        name = "category"
                    ),
                    title = "Task",
                    description = "Task description",
                )
            ))
        }

    }
}