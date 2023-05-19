package mkn.todo.addtask.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import mkn.todo.addtask.domain.AddTaskUseCase
import javax.inject.Inject

@HiltViewModel
internal class AddTaskViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val addTaskUseCase: AddTaskUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow("Add New Task")
    val uiState = _uiState.asStateFlow()

    init {

    }

}