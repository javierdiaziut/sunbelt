package com.rankmi.app.data.repository

import com.rankmi.app.data.remote.model.DomainResponseEntry
import com.rankmi.app.data.remote.source.DomainRemoteDataSource
import com.rankmi.app.domain.model.Domain

class DomainRepository(
    private val domainRemoteDataSource: DomainRemoteDataSource
) {
    suspend fun checkDomain(company : String): DomainResponseEntry? {
        return domainRemoteDataSource.checkDomain(company)
    }
}