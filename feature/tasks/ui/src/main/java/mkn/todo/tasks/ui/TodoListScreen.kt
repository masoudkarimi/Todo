package mkn.todo.tasks.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val TodoRoute = "todos"

fun NavGraphBuilder.todoListScreen() {
    composable(TodoRoute) {
        val viewModel : TodoListViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()
        TodoListScreen(uiState = uiState, viewModel::addNewTask)
    }
}

@Composable
internal fun TodoListScreen(
    uiState: TasksListState,
    addNewTask: () -> Unit
) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Tasks Count = ${uiState.tasks.size}")
        Button(onClick = addNewTask) {
            Text(text = "Add New Task")
        }
    }
}