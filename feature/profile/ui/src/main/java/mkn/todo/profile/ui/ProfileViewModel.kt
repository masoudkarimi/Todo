package mkn.todo.profile.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
internal class ProfileViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,

) : ViewModel() {

    private val _uiState = MutableStateFlow("Profile")
    val uiState = _uiState.asStateFlow()

    init {

    }

}