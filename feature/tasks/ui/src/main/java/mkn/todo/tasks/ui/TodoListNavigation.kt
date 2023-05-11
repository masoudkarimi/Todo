package mkn.todo.tasks.ui

import androidx.navigation.NavController

fun NavController.navigateToTodoList() {
    this.navigate("todos")
}