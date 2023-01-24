package com.atreus.asisapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.atreus.asisapp.data.model.TaskItem

@Dao
interface TaskItemDao
{
    @Query("SELECT * FROM task_item_table ORDER BY id ASC")
    suspend fun allTaskItems(): List<TaskItem>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTaskItem(taskItem: TaskItem)

    @Update
    suspend fun updateTaskItem(taskItem: TaskItem)

    @Delete
    suspend fun deleteTaskItem(taskItem: TaskItem)
}