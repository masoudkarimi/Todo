package mkn.todo.tasks.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val TodosRoute = "todos"

fun NavGraphBuilder.todoListScreen(
    addNewTask: () -> Unit,
    profileClick: () -> Unit
) {
    composable(TodosRoute) {
        val viewModel : TodoListViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()
        TodoListScreen(uiState = uiState, addNewTask, profileClick)
    }
}

@Composable
internal fun TodoListScreen(
    uiState: TasksListState,
    addNewTask: () -> Unit,
    profileClick: () -> Unit,
) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Tasks Count = ${uiState.tasks.size}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = addNewTask) {
            Text(text = "Add New Task")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = profileClick) {
            Text(text = "Profile")
        }
    }
}