package com.demo.sunbelt.data.remote.source

import com.demo.sunbelt.data.remote.model.ListResponseEntry
import com.demo.sunbelt.data.remote.net.ListRemoteApi
import com.up.core.extension.await

class ListDataSource(
    private val listRemoteApi: ListRemoteApi
) {
    suspend fun getNewsList(country: String): ListResponseEntry? {
        return listRemoteApi.getNewsList(country, "2e9a3eda70cd457789dcc38fd9a73cc9").await()

    }
}