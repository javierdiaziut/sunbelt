package com.rankmi.app.data.repository

import android.content.Context
import com.google.gson.Gson
import com.rankmi.app.R
import com.rankmi.app.data.remote.model.FeedbackResponseEntry
import com.rankmi.app.data.remote.model.FeedbackUsersResponseEntry
import com.rankmi.app.data.remote.source.FeedbackListDataSource
import com.rankmi.app.data.remote.source.FeedbackUsersDataSource

class FeedbackGetUsersRepository(
    private val feedbackDataSource: FeedbackUsersDataSource,
    private val context: Context
) {


    suspend fun getUsers(): FeedbackUsersResponseEntry {

        val json = context.resources.openRawResource(R.raw.json_users_mock)
            .bufferedReader().use { it.readText() }
        val gson = Gson()
        return gson.fromJson(json, FeedbackUsersResponseEntry::class.java)
    }

//    suspend fun getFeedbackList(): FeedbackResponseEntry {
//        return feedbackDataSource.getFeedbackList()
//    }

}