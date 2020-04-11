package com.rankmi.app.data.remote.model

import com.google.gson.annotations.SerializedName
import com.rankmi.app.data.DataConstants.CLIENT_ID
import com.rankmi.app.data.DataConstants.CLIENT_SECRET
import com.rankmi.app.domain.model.Domain

data class DomainResponseEntry(
    @SerializedName(CLIENT_ID) val clientId: String,
    @SerializedName(CLIENT_SECRET) val clientSecret: String,
    val domain: String,
    val realm: String,
    val error: String
)

fun DomainResponseEntry.toDomain() = Domain(
    clientId = clientId,
    clientSecret = clientSecret,
    domain = domain,
    realm = realm,
    error = error
)