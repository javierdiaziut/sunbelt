package com.rankmi.app.data.remote.model

import com.google.gson.annotations.SerializedName
import com.rankmi.app.data.DataConstants
import com.rankmi.app.domain.model.Users

data class FeedbackUsersEntry(
    val area: String,
    val avatar: String,
    val email: String,
    @SerializedName(DataConstants.FIRST_NAME) val firstName: String,
    val id: Int,
    @SerializedName(DataConstants.LAST_NAME) val lastName: String,
    @SerializedName(DataConstants.MIDDLE_NAME) val middleName: String,
    @SerializedName(DataConstants.MOTHERS_NAME) val mothersName: String

    )

fun FeedbackUsersEntry.toUsers() = Users(
    area = area,
    avatar = avatar,
    email = email,
    firstName = firstName,
    id = id,
    lastName = lastName,
    middleName = middleName,
    motherName = mothersName

)