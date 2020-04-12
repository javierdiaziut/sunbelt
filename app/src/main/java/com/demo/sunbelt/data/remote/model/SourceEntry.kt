package com.demo.sunbelt.data.remote.model

import com.demo.sunbelt.domain.model.Source

data class SourceEntry(
    val id: String?,
    val name: String
)

fun SourceEntry.toSource() = Source(
    id = id,
    name = name
)