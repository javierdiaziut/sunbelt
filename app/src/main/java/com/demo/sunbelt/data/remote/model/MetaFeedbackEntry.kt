package com.rankmi.app.data.remote.model

data class MetaFeedbackEntry(
    val current_page: Int,
    val prev_page: Boolean,
    val next_page: Boolean,
    val total_pages: Int,
    val total_count: Int
)