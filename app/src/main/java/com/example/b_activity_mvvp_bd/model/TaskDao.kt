package com.example.b_activity_mvvp_bd.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
    interface TaskDao {
//Inserta Tarea
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(Task: TaskEntity)


//depende del auto Completador Abort Salta la erronea y Aborta
    //Ignore realiza importr tareas y omite las tareas con errores
//inserta lista de tareas
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTask(listTask: List<TaskEntity>)

    //Update
    @Update
    fun updateTask(task: TaskEntity)

    //borrar tarea
    @Delete
    fun deleteTask(task: TaskEntity)
//borra todo los elementos
    @Query("DELETE FROM task_table")
    fun deleteAll()

//selecciona informacion
    @Query("SELECT * FROM task_table")
    fun getAllTASK(): LiveData<List<TaskEntity>>

    //Obtiene informaciom por titulo y solo entrega 1 resultado
    @Query("SELECT * FROM task_table WHERE title = :title LIMIT 1")
    fun getTaskByTitle(title: String) : LiveData<TaskEntity>

    //selecciona informacion por Id
    @Query("SELECT * FROM task_table Where id = :id ")
    fun getBYID(id: Int) : LiveData<TaskEntity>
}