package com.rankmi.app.data.remote.model

import com.rankmi.app.domain.model.StarRating

data class StarRatingEntry(
    val selected: Int,
    val shape: String,
    val min_value: Int,
    val max_value: Int,
    val values: ArrayList<RatingEntry>

)

fun StarRatingEntry.toStarRating() = StarRating(
    selected = selected,
    shape = shape,
    minValue = min_value,
    maxValue = max_value,
    values = ArrayList(values.map { it.toRating() })
)