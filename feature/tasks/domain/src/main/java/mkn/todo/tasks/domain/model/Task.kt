package mkn.todo.tasks.domain.model

data class Task(
    val id: Long,
    val category: Category,
    val title: String,
    val description: String
)