package com.example.b_activity_mvvp_bd.model

import android.content.Context
import android.provider.CalendarContract
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [TaskEntity::class], version = 1 )
abstract class TaskDataBase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    companion object{
        @Volatile
        private var INSTANCE : TaskDataBase? = null

        fun getdataBase(context: Context) : TaskDataBase {
            val tempInstances = INSTANCE
            if (tempInstances != null) {
                return tempInstances
            }
            synchronized(this){
                val instance : Room.databaseBuilder(
                context.applicationContext
                TaskDataBase::class.java
                "Task_db")
                .build()
                INSTANCE = instance
                return instance
            }

        }
    }
}