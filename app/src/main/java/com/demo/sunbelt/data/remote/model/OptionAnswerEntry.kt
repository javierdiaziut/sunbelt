package com.rankmi.app.data.remote.model

import com.rankmi.app.domain.model.OptionAnswer

data class OptionAnswerEntry(
    val id: Int,
    val label: String,
    val order : Int
)

fun OptionAnswerEntry.toOptionAnswer() = OptionAnswer(
    id = id,
    label = label,
    order = order
)