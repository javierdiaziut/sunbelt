package com.rankmi.app.data.repository

import android.content.Context
import com.google.gson.Gson
import com.rankmi.app.R
import com.rankmi.app.data.remote.model.FeedbackResponseEntry
import com.rankmi.app.data.remote.source.FeedbackListDataSource

class FeedbackListRepository(
    private val feedbackDataSource: FeedbackListDataSource,
    private val context: Context
) {


    suspend fun getFeedbackList(): FeedbackResponseEntry {

        val json = context.resources.openRawResource(R.raw.mockjson)
            .bufferedReader().use { it.readText() }
        val gson = Gson()
        return gson.fromJson(json, FeedbackResponseEntry::class.java)
    }

//    suspend fun getFeedbackList(): FeedbackResponseEntry {
//        return feedbackDataSource.getFeedbackList()
//    }

}