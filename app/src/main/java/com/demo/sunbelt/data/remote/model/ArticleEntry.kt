package com.demo.sunbelt.data.remote.model

import com.demo.sunbelt.domain.model.Article

data class ArticleEntry(
    val source: SourceEntry,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)

fun ArticleEntry.toArticle() = Article(
    source = source.toSource(),
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt= publishedAt,
    content = content
)