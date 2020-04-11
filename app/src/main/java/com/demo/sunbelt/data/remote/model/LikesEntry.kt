package com.rankmi.app.data.remote.model

import com.google.gson.annotations.SerializedName
import com.rankmi.app.data.DataConstants.FIRST_NAME
import com.rankmi.app.data.DataConstants.LAST_NAME
import com.rankmi.app.data.DataConstants.MIDDLE_NAME
import com.rankmi.app.data.DataConstants.MOTHERS_NAME
import com.rankmi.app.domain.model.Likes

data class LikesEntry(
    @SerializedName(FIRST_NAME) val firstName: String,
    @SerializedName(MIDDLE_NAME) val middleName: String,
    @SerializedName(LAST_NAME) val lastName: String,
    @SerializedName(MOTHERS_NAME) val mothersName: String,
    val avatar: String
)

fun LikesEntry.toLikes() = Likes(
    firstName = firstName,
    middleName = middleName,
    lastName = lastName,
    mothersName = mothersName,
    avatar = avatar
)