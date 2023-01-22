package com.example.nyobahabitroom

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class HabitViewModel(private val repository: HabitRepository) : ViewModel() {
    val allHabits: LiveData<List<Habit>> = repository.allHabits.asLiveData()

    fun addHabits(habit: Habit) = viewModelScope.launch {
        repository.addHabit(habit)
    }

    fun updateHabits(habit: Habit) = viewModelScope.launch {
        repository.updateHabit(habit)
    }

    fun deleteHabits(habit: Habit) = viewModelScope.launch {
        repository.deleteHabit(habit)
    }
}

class TaskItemModelFactory(private val repository: HabitRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(HabitViewModel::class.java))
            return HabitViewModel(repository) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}