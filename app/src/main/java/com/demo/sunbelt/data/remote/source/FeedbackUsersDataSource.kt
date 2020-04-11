package com.rankmi.app.data.remote.source

import com.rankmi.app.data.remote.model.FeedbackResponseEntry
import com.rankmi.app.data.remote.model.FeedbackUsersResponseEntry
import com.rankmi.app.data.remote.model.LoginResponseEntry
import com.rankmi.app.data.remote.net.FeedbackRemoteApi
import com.rankmi.app.data.remote.net.FeedbackUsersRemoteApi
import com.rankmi.app.data.remote.net.LoginRemoteApi
import com.rankmi.app.domain.request.LoginRequest
import retrofit2.await

class FeedbackUsersDataSource(
    private val feedbackUsersRemoteApi: FeedbackUsersRemoteApi)
{
    suspend fun getFeedbackList(): FeedbackUsersResponseEntry {
        return feedbackUsersRemoteApi.getUsers().await()
    }
}