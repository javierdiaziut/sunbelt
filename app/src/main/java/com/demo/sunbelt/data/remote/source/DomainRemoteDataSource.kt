package com.rankmi.app.data.remote.source

import com.rankmi.app.data.remote.model.DomainResponseEntry
import com.rankmi.app.data.remote.net.DomainRemoteApi
import com.up.core.extension.await

class DomainRemoteDataSource(
    private val domainRemoteApi: DomainRemoteApi
) {
    suspend fun checkDomain(company: String): DomainResponseEntry? {
        return domainRemoteApi.checkDomain(company).await()

    }
}