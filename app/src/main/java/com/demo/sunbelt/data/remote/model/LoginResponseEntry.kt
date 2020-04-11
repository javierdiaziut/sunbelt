package com.rankmi.app.data.remote.model

data class LoginResponseEntry(
    val access_token: String,
    val expires_in: String,
    val refresh_expires_in: String,
    val refresh_token: String,
    val token_type: String,
    val session_state: String,
    val scope: String,
    val error: String,
    val error_description: String

)