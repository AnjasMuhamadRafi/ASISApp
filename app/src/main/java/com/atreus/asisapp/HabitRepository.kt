package com.example.nyobahabitroom

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HabitRepository @Inject constructor (private val habitDao: HabitDao) {
    val allHabits: Flow<List<Habit>> = habitDao.getHabit()
    fun getPlant(habitId: String) = habitDao.getHabitById(habitId)

    companion object {
        @Volatile private var instance: HabitRepository? = null
        fun getInstance(plantDao: HabitDao) =
            instance ?: synchronized(this) {
                instance ?: HabitRepository(plantDao).also { instance = it }
            }
    }

    suspend fun addHabit(habit: Habit) {
        habitDao.insertHabit(habit)
    }

    suspend fun updateHabit(habit: Habit) {
        habitDao.updateHabit(habit)
    }

    suspend fun deleteHabit(habit: Habit) {
        habitDao.deleteHabit(habit)
    }
}