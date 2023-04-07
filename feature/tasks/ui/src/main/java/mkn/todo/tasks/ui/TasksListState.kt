package mkn.todo.tasks.ui

import mkn.todo.tasks.domain.model.Task

data class TasksListState(
    val isLoading: Boolean = false,
    val isError : Boolean = false,
    val tasks: List<Task> = emptyList()
)