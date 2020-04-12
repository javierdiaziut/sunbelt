package com.demo.sunbelt.data.remote.model

data class ListResponseEntry(
    val status: String,
    val totalResults: Int,
    val articles: ArrayList<ArticleEntry>
)