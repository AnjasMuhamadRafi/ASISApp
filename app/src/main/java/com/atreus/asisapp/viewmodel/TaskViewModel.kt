package com.atreus.asisapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.atreus.asisapp.data.AsisRepository
import com.atreus.asisapp.data.database.AsisDatabase
import com.atreus.asisapp.data.model.TaskItem
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDate

class TaskViewModel(application: Application): AndroidViewModel(application) {

    public val taskItems : LiveData<List<TaskItem>>
    private val repository : AsisRepository

    init {
        val taskItemDao = AsisDatabase.getDatabase(application).taskItemDao()
        val habitDao = AsisDatabase.getDatabase(application).habitDao()
        repository = AsisRepository(taskItemDao, habitDao)
        taskItems = repository.getAllTasks()
    }

    fun addTaskItem(taskItem: TaskItem) = viewModelScope.launch {
        repository.insertTaskItem(taskItem)
    }

    fun updateTaskItem(taskItem: TaskItem) = viewModelScope.launch {
        repository.updateTaskItem(taskItem)
    }

    fun setCompleted(taskItem: TaskItem) = viewModelScope.launch {
        if (!taskItem.isCompleted())
            taskItem.completedDateString = TaskItem.dateFormatter.format(LocalDate.now())
        repository.updateTaskItem(taskItem)
    }
}