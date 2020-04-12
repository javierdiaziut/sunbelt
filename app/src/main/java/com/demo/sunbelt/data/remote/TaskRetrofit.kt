package com.rankmi.app.data.remote

import androidx.lifecycle.LiveData
import com.demo.sunbelt.data.local.TaskEntity
import com.demo.sunbelt.domain.db.Task
import com.rankmi.app.domain.TaskRepository

class TaskRetrofit(private val taskService: TaskService):
    TaskRepository {

  override fun addTask() {
    taskService.addTask()
  }

  override fun deleteTask() {
    taskService.deleteTask("1")
  }
}