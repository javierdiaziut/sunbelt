package com.rankmi.app.domain

import androidx.lifecycle.LiveData
import com.demo.sunbelt.data.local.TaskEntity

interface TaskRepository {

  fun getAllTasks(): LiveData<List<TaskEntity>>

  fun addTask()

  fun deleteTask()
}