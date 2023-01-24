package com.atreus.asisapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.atreus.asisapp.data.AsisRepository
import com.atreus.asisapp.data.database.AsisDatabase
import com.atreus.asisapp.data.model.HabitData
import kotlinx.coroutines.launch

class HabitViewModel(application: Application) : AndroidViewModel(application) {

    public val habit : LiveData<List<HabitData>>
    private val repository : AsisRepository

    init {
        val taskItemDao = AsisDatabase.getDatabase(application).taskItemDao()
        val habitDao = AsisDatabase.getDatabase(application).habitDao()
        repository = AsisRepository(taskItemDao, habitDao)
        habit = repository.getAllHabit()
    }

    fun addHabits(habit: HabitData) = viewModelScope.launch {
        repository.addHabit(habit)
    }

    fun updateHabits(habit: HabitData) = viewModelScope.launch {
        repository.updateHabit(habit)
    }

    fun deleteHabits(habit: HabitData) = viewModelScope.launch {
        repository.deleteHabit(habit)
    }
}
