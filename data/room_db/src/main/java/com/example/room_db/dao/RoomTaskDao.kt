package com.example.room_db.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import mkn.todo.db.dao.TaskDao
import mkn.todo.db.model.Task
import mkn.todo.db.model.TaskWithCategory

@Dao
abstract class RoomTaskDao: TaskDao {
    @Query("SELECT * from tasks")
    abstract override fun getAllTasks(): Flow<List<TaskWithCategory>>

    @Query("SELECT * FROM tasks WHERE id = :id")
    abstract override fun findTaskById(id: Long): TaskWithCategory?

    @Insert
    abstract override suspend fun addNewTask(task: Task): Long

    @Update
    abstract override suspend fun updateTask(task: Task)

    @Delete
    abstract override suspend fun deleteTask(task: Task)
}