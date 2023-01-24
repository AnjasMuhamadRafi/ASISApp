package com.atreus.asisapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.atreus.asisapp.data.model.HabitData
import com.atreus.asisapp.data.model.TaskItem

@Database(entities = [TaskItem::class, HabitData::class], version = 1, exportSchema = false)
abstract class AsisDatabase : RoomDatabase()
{
    abstract fun taskItemDao(): TaskItemDao
    abstract fun habitDao(): HabitDao

    companion object
    {
        @Volatile
        private var INSTANCE: AsisDatabase? = null

        fun getDatabase(context: Context): AsisDatabase
        {
            return INSTANCE ?: synchronized(this)
                {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AsisDatabase::class.java,
                        "asis_database"
                    ).build()
                    INSTANCE = instance
                    instance
                }
        }
    }
}