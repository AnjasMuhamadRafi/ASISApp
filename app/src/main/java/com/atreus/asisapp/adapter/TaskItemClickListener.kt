package com.atreus.asisapp.adapter

import com.atreus.asisapp.data.model.TaskItem

interface TaskItemClickListener
{
    fun editTaskItem(taskItem: TaskItem)
    fun completeTaskItem(taskItem: TaskItem)
}