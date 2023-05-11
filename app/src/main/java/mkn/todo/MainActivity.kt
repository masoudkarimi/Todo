package mkn.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import mkn.todo.tasks.ui.todoListScreen
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import mkn.todo.base.ui.TodoTheme
import mkn.todo.tasks.ui.TodoRoute

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
            startDestination = TodoRoute,
            modifier = modifier
        ) {
            todoListScreen()
        }
    }
}
