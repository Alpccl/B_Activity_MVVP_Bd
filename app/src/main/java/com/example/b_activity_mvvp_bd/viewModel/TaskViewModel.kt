package com.example.b_activity_mvvp_bd.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.b_activity_mvvp_bd.TaskRepository
import com.example.b_activity_mvvp_bd.model.TaskDataBase
import com.example.b_activity_mvvp_bd.model.TaskEntity
import kotlinx.coroutines.launch

class TaskViewModel(application : Application) : AndroidViewModel(application) {

    //Variable que representa al repositorio
    private val repository: TaskRepository
   //LiveData Expone info del modelo
    val allTask : LiveData<List<TaskEntity>>
    init{
        val taskdao = TaskDataBase.getdataBase(application)
        repository = TaskRepository(taskdao)
        allTask = repository.listAllTask
    }

    fun insertTask(task :TaskEntity) = viewModelScope.launch {
        repository.insertTask(task)
    }




}