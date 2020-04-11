package com.rankmi.app.data.remote.model

import com.rankmi.app.domain.model.CompetencesValue

data class CompetencesValueEntry(
    val type: String,
    val name: String,
    val description: String
)

fun CompetencesValueEntry.toCompetencesValue() = CompetencesValue(
    type = type,
    name = name,
    description = description
)