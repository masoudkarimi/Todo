package mkn.todo.addtask.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val AddTaskRoute = "add"

fun NavGraphBuilder.addTaskScreen() {
    composable(AddTaskRoute) {
        val viewModel : AddTaskViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()
        AddTaskScreen(uiState = uiState)
    }
}

@Composable
internal fun AddTaskScreen(
    uiState: String,
) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var title by rememberSaveable { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = title,
            onValueChange = { newText ->
                title = newText
            },
            label = { Text(text = stringResource(id = R.string.title)) },
            placeholder = { Text(text = stringResource(id = R.string.task_title_example)) },
        )

        Spacer(modifier = Modifier.height(10.dp))

        var description by rememberSaveable { mutableStateOf(TextFieldValue("")) }

        TextField(
            value = description,
            onValueChange = { newText ->
                description = newText
            },
            label = { Text(text = stringResource(id = R.string.description)) },
            placeholder = { Text(text = stringResource(id = R.string.task_description_example)) },
        )


    }
}