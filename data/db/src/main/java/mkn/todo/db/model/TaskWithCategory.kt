package mkn.todo.db.model

import androidx.room.Embedded
import androidx.room.Relation

data class TaskWithCategory(
    @Embedded
    val category: Category? = null,

    @Relation(
        parentColumn = "id",
        entityColumn = "category_id"
    )
    val task: Task? = null
)