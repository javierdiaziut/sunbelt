package com.rankmi.app.data.repository

import com.rankmi.app.data.remote.model.LoginResponseEntry
import com.rankmi.app.data.remote.source.LoginDataSource
import com.rankmi.app.domain.request.LoginRequest

class LoginRepository(
    private val loginDataSource: LoginDataSource
) {
    suspend fun login(request : LoginRequest): LoginResponseEntry {
        return loginDataSource.login(request)
    }

}