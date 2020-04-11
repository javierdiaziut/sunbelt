package com.rankmi.app.data.remote.source

import com.rankmi.app.data.remote.model.LoginResponseEntry
import com.rankmi.app.data.remote.net.LoginRemoteApi
import com.rankmi.app.domain.request.LoginRequest
import retrofit2.await

class LoginDataSource(
    private val loginRemoteApi: LoginRemoteApi)
{
    suspend fun login(request : LoginRequest): LoginResponseEntry {
        return loginRemoteApi.login(request.client_id, request.client_secret, request.grant_type,
            request.password, request.username).await()
    }
}