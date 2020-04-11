package com.rankmi.app.data.remote.net

import com.rankmi.app.data.remote.model.DomainResponseEntry
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DomainRemoteApi {

    @GET("http://35.236.89.71:5000/enterprises/{company}")
    fun checkDomain(@Path("company") company: String): Call<DomainResponseEntry>

}