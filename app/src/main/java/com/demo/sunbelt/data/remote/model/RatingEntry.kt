package com.rankmi.app.data.remote.model

import com.rankmi.app.domain.model.Rating

data class RatingEntry(
    val value: Int,
    val converted: Int,
    val label: String
)

fun RatingEntry.toRating() = Rating(
    value = value,
    converted = converted,
    label = label
)