package com.demo.sunbelt.data.remote.net

import com.demo.sunbelt.data.remote.model.ListResponseEntry
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ListRemoteApi {

    @GET("top-headlines")
    fun getNewsList(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<ListResponseEntry>
}