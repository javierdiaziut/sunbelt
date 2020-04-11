package com.rankmi.app.data.remote.source

import com.rankmi.app.data.remote.model.FeedbackResponseEntry
import com.rankmi.app.data.remote.model.LoginResponseEntry
import com.rankmi.app.data.remote.net.FeedbackRemoteApi
import com.rankmi.app.data.remote.net.LoginRemoteApi
import com.rankmi.app.domain.request.LoginRequest
import retrofit2.await

class FeedbackListDataSource(
    private val feedbackListRemoteApi: FeedbackRemoteApi)
{
    suspend fun getFeedbackList(): FeedbackResponseEntry {
        return feedbackListRemoteApi.getListFeedback().await()
    }
}