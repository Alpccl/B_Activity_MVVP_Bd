package com.example.b_activity_mvvp_bd.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.b_activity_mvvp_bd.model.TaskRepository
import com.example.b_activity_mvvp_bd.model.TaskDataBase
import com.example.b_activity_mvvp_bd.model.TaskEntity
import kotlinx.coroutines.launch

class TaskViewModel(application : Application) : AndroidViewModel(application) {

    // variable que representa al repositorio
    private val repository: TaskRepository
    //LiveData que expone la info del modelo.
    val allTask : LiveData<List<TaskEntity>>

    init {
        val taskDao = TaskDataBase.getdataBase(application).getTaskDao()
        repository = TaskRepository(taskDao)
        allTask = repository.listAllTask
    }

    // Aqui manejamos la coroutina
    fun insertTask(task: TaskEntity) = viewModelScope.launch {
        repository.insertTask(task)
    }

    fun updateTask(task: TaskEntity) = viewModelScope.launch {
        repository.updateTask(task)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun getTaskById(id: Int): LiveData<TaskEntity> {
        return repository.getTaskByID(id)
    }



}