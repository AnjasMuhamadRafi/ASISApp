package com.atreus.asisapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.atreus.asisapp.data.model.HabitData

@Dao
interface HabitDao {
    @Query("SELECT * FROM habit_table")
    fun getHabit(): List<HabitData>

    @Query("SELECT * FROM habit_table WHERE id = :habitId")
    fun getHabitById(habitId: String): HabitData

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertHabit(habit: HabitData)

    @Update
    suspend fun updateHabit(habit: HabitData)

    @Delete
    suspend fun deleteHabit(habit: HabitData)
}