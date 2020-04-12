package com.demo.sunbelt.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.demo.sunbelt.data.remote.model.ListResponseEntry
import com.demo.sunbelt.domain.usecase.ListUseCase
import com.up.core.extension.LiveResult

class ListViewModel(
    private val listUseCase: ListUseCase,
    val listLiveData: LiveResult<ListResponseEntry> = LiveResult()
) : ViewModel() {

    fun getNewsListDomain(country: String) {
        listUseCase.execute(listLiveData, country)
    }

}