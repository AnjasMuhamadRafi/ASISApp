package com.atreus.asisapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atreus.asisapp.data.database.HabitDao
import com.atreus.asisapp.data.database.TaskItemDao
import com.atreus.asisapp.data.model.HabitData
import com.atreus.asisapp.data.model.TaskItem
import kotlinx.coroutines.runBlocking

class AsisRepository(var taskItemDao: TaskItemDao, var habitDao: HabitDao)
{
    private val task = MutableLiveData<List<TaskItem>>()
    private val habit = MutableLiveData<List<HabitData>>()

    fun getAllTasks():LiveData<List<TaskItem>> {
        runBlocking {
            task.value = taskItemDao.allTaskItems()
        }
        return task
    }

    fun getAllHabit():LiveData<List<HabitData>> {
        habit.value = habitDao.getHabit()
        return habit
    }

    suspend fun insertTaskItem(taskItem: TaskItem)
    {
        runBlocking {
            taskItemDao.insertTaskItem(taskItem)
        }
    }

    suspend fun updateTaskItem(taskItem: TaskItem)
    {
        runBlocking {
            taskItemDao.updateTaskItem(taskItem)
        }
    }

    suspend fun addHabit(habit: HabitData) {
        habitDao.insertHabit(habit)
    }

    suspend fun updateHabit(habit: HabitData) {
        habitDao.updateHabit(habit)
    }

    suspend fun deleteHabit(habit: HabitData) {
        habitDao.deleteHabit(habit)
    }
}