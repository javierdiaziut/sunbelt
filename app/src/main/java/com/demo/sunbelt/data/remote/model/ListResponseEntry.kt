package com.demo.sunbelt.data.remote.model

import com.demo.sunbelt.domain.model.Article

data class ListResponseEntry(
    val status: String,
    val totalResults: Int,
    val articles: ArrayList<Article>
)