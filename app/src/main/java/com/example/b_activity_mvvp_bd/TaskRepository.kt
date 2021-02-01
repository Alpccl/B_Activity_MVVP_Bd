package com.example.b_activity_mvvp_bd

import androidx.lifecycle.LiveData
import com.example.b_activity_mvvp_bd.model.TaskDao
import com.example.b_activity_mvvp_bd.model.TaskDataBase
import com.example.b_activity_mvvp_bd.model.TaskEntity

class TaskRepository(private val taskDao: TaskDataBase){
    //Este Value va a contener toda la info de la base de datos

    val listAllTask: LiveData<List<TaskEntity>> = TaskDao.getAllTask()

            fun insertTask (task: TaskEntity){
                taskDao.insertTask(task)
            }
    fun deleteTask(task: TaskEntity){
                taskDao.deleteTask(task)
    }

}