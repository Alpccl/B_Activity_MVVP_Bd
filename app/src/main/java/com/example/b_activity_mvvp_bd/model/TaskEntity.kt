package com.example.b_activity_mvvp_bd.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "task_table")
data class TaskEntity(@PrimaryKey(autoGenerate = true) @NotNull
                      val id : Int = 0,
                      val title :String,
                      val description: String,
                      val author: String)



