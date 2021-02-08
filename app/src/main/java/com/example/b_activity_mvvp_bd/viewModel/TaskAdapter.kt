package com.example.b_activity_mvvp_bd.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.b_activity_mvvp_bd.databinding.TaskItemListBinding
import com.example.b_activity_mvvp_bd.model.TaskEntity

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskVH>() {

    private var listTask = listOf<TaskEntity>()

    private val selectedTaskItem = MutableLiveData<TaskEntity>()
    fun selectedItem(): LiveData<TaskEntity> = selectedTaskItem

    fun update(list : List<TaskEntity>) {
        listTask = list
        notifyDataSetChanged()
    }

    inner class TaskVH(private val binding: TaskItemListBinding) :
            RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(task : TaskEntity) {
            binding.tvTitle.text = task.title
            binding.tvDescription.text = task.description
            binding.tvAuthor.text = task.author
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            selectedTaskItem.value = listTask[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskVH {
        return TaskVH(TaskItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TaskVH, position: Int) {
        val task = listTask[position]
        holder.bind(task)
    }

    override fun getItemCount(): Int = listTask.size

}