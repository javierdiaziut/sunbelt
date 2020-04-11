package com.demo.sunbelt.util

import android.content.SharedPreferences
import androidx.core.content.edit
import org.koin.core.KoinComponent
import org.koin.core.inject


object AppPreferences : KoinComponent {

    private val preferences: SharedPreferences by inject()

    const val AUTH_TOKEN_DEFAULT = "authTokenDefault"
    private const val AUTH_TOKEN = "authToken"
    private const val FIREBASE_TOKEN = "firebaseToken"
    private const val CLIENT_ID = "client_id"
    private const val CLIENT_SECRET = "client_secret"
    private const val REFRESH_TOKEN = "client_secret"
    private const val IS_LOGGED = "is_logged"

    var authToken: String?
        get() = preferences.getString(AUTH_TOKEN, AUTH_TOKEN_DEFAULT)
        set(value) = preferences.edit {
            putString(AUTH_TOKEN, "Bearer $value").apply()
        }

    var firebaseToken: String?
        get() = preferences.getString(FIREBASE_TOKEN, "")
        set(value) = preferences.edit {
            putString(FIREBASE_TOKEN, value).apply()
        }

    fun cleanSession() : Boolean {
        preferences.edit().remove(IS_LOGGED).apply()
        preferences.edit().remove(AUTH_TOKEN).apply()
        preferences.edit().remove(CLIENT_SECRET).apply()
        preferences.edit().remove(CLIENT_ID).apply()
        return !isLogged
    }

    var clientId: String?
        get() = preferences.getString(CLIENT_ID, "")
        set(value) = preferences.edit {
            putString(CLIENT_ID, value).apply()
        }

    var clientSecret: String?
        get() = preferences.getString(CLIENT_SECRET, "")
        set(value) = preferences.edit {
            putString(CLIENT_SECRET, value).apply()
        }

    var refreshToken: String?
        get() = preferences.getString(REFRESH_TOKEN, "")
        set(value) = preferences.edit {
            putString(REFRESH_TOKEN, value).apply()
        }

    var isLogged: Boolean
        get() = preferences.getBoolean(IS_LOGGED, false)
        set(value) = preferences.edit {
            putBoolean(IS_LOGGED, value).apply()
        }
}