package com.demo.sunbelt.domain.usecase

import com.demo.sunbelt.data.remote.model.ListResponseEntry
import com.demo.sunbelt.data.repository.ListRepository
import com.up.core.coroutines.ResultUseCase
import kotlinx.coroutines.Dispatchers

class ListUseCase(
    private val repository: ListRepository
) : ResultUseCase<String, ListResponseEntry>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(params: String): ListResponseEntry? {
        return repository.checkDomain(params)
    }
}