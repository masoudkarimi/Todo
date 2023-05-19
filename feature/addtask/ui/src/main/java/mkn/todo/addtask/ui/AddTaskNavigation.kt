package mkn.todo.addtask.ui

import androidx.navigation.NavController

fun NavController.navigateToAddTask() {
    this.navigate(AddTaskRoute)
}