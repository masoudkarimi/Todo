package mkn.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import mkn.todo.tasks.ui.todoListScreen
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import mkn.todo.addtask.ui.addTaskScreen
import mkn.todo.addtask.ui.navigateToAddTask
import mkn.todo.base.ui.TodoTheme
import mkn.todo.profile.ui.navigateToProfile
import mkn.todo.profile.ui.profileScreen
import mkn.todo.tasks.ui.TodosRoute

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppContent()
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun AppContent(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    TodoTheme {
        NavHost(
            navController = navController,
            startDestination = TodosRoute,
            modifier = modifier
        ) {
            todoListScreen(
                addNewTask = navController::navigateToAddTask,
                profileClick = navController::navigateToProfile
            )
            addTaskScreen()
            profileScreen()
        }
    }
}
