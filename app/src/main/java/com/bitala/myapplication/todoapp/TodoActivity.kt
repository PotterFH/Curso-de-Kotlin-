package com.bitala.myapplication.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.bitala.myapplication.R
import com.bitala.myapplication.todoapp.TaskCategory.*

class TodoActivity : AppCompatActivity() {
    private val categories = listOf(
        Bussiness,
        Personal,
        Other
    )

    private val tasks = mutableListOf(
        Task("PruebaBussines", TaskCategory.Bussiness),
        Task("PruebaPersonal", TaskCategory.Personal),
        Task("PruebaOther", Other),
    )

    private lateinit var rvCategory: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter

    private lateinit var rvTasks:RecyclerView
    private lateinit var taskAdapter: TasksAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponents()
        initUI()
    }

    private fun initComponents() {
        rvCategory = findViewById(R.id.rvCategory)
        rvTasks = findViewById(R.id.rvTasks)
    }

    private fun initUI() {
        categoryAdapter = CategoryAdapter(categories)
        rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategory.adapter = categoryAdapter

        taskAdapter = TasksAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter
    }
}