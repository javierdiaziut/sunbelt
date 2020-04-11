package com.rankmi.app.data.remote.net

import com.rankmi.app.data.remote.model.FeedbackResponseEntry
import com.rankmi.app.data.remote.model.LoginResponseEntry
import com.rankmi.app.domain.request.LoginRequest
import retrofit2.Call
import retrofit2.http.*

interface FeedbackRemoteApi {

    @GET("")
    fun getListFeedback(): Call<FeedbackResponseEntry>
}