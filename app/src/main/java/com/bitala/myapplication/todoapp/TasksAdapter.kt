package com.bitala.myapplication.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitala.myapplication.R

class TasksAdapter (private val tasks:List<Task>) : RecyclerView.Adapter<TaskViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
     val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent,false)
        return TaskViewHolder(view)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.render(tasks[position])

    }

}