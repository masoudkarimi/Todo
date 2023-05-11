package mkn.todo.tasks.ui

import mkn.todo.data.model.Task


internal data class TasksListState(
    val isLoading: Boolean = false,
    val isError : Boolean = false,
    val tasks: List<Task> = emptyList()
)