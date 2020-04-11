package com.demo.sunbelt.data.interceptor

import com.demo.sunbelt.util.AppPreferences
import okhttp3.Interceptor
import okhttp3.Response


class RefreshAuthTokenInterceptor(
    private val appPreferences: AppPreferences
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        val header = response.header("id-token", "")

        if (!header.isNullOrEmpty()) {
            appPreferences.authToken = header
        }

        return response
    }
}