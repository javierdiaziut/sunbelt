package com.rankmi.app.data.remote.net

import com.rankmi.app.data.remote.model.LoginResponseEntry
import com.rankmi.app.domain.request.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginRemoteApi {

    @FormUrlEncoded
    @POST("http://34.94.187.108:8080/auth/realms/blackmind/protocol/openid-connect/token")
    fun login(@Field("client_id") client_id: String,
              @Field("client_secret") client_secret: String,
              @Field("grant_type") grant_type: String,
              @Field("password") password: String,
              @Field("username") username: String): Call<LoginResponseEntry>
}