package com.example.b_activity_mvvp_bd.model

import androidx.lifecycle.LiveData
import com.example.b_activity_mvvp_bd.model.TaskDao
import com.example.b_activity_mvvp_bd.model.TaskDataBase
import com.example.b_activity_mvvp_bd.model.TaskEntity

class TaskRepository(private val taskDao: TaskDao){
    //Este Value va a contener toda la info de la base de datos

    val listAllTask : LiveData<List<TaskEntity>> = taskDao.getAllTASK()

    suspend fun insertTask(task: TaskEntity) {
        taskDao.insertTask(task)
    }

    suspend fun updateTask(task: TaskEntity){
        taskDao.updateTask(task)
    }

    suspend fun deleteAll() {
        taskDao.deleteAll()
    }

    fun getTaskByID(id: Int): LiveData<TaskEntity> {
        return taskDao.getBYID(id)
    }

}