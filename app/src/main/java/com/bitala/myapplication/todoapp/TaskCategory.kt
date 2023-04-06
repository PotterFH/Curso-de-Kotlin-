package com.bitala.myapplication.todoapp

sealed class TaskCategory {
    object Personal : TaskCategory()
    object Bussiness : TaskCategory()
    object Other : TaskCategory()
}