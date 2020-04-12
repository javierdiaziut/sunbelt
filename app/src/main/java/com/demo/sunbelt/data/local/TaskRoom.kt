package com.demo.sunbelt.data.local

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.demo.sunbelt.domain.db.Task
import com.rankmi.app.data.local.TaskRoomDao
import com.rankmi.app.domain.TaskRepository


class TaskRoom(private val taskRoomDao: TaskRoomDao) :
    TaskRepository {

    @WorkerThread
    suspend fun insert(task: TaskEntity) {
        taskRoomDao.insert(task)
    }

    override fun addTask() {
    }

    override fun deleteTask() {
    }
}