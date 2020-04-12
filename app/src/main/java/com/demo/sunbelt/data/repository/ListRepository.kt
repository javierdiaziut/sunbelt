package com.demo.sunbelt.data.repository

import com.demo.sunbelt.data.remote.model.ListResponseEntry
import com.demo.sunbelt.data.remote.source.ListDataSource


class ListRepository(
    private val listRemoteDataSource: ListDataSource
) {
    suspend fun checkDomain(country : String): ListResponseEntry? {
        return listRemoteDataSource.getNewsList(country)
    }
}