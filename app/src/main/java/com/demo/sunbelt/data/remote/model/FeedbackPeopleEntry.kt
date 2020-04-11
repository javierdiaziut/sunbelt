package com.rankmi.app.data.remote.model

import com.google.gson.annotations.SerializedName
import com.rankmi.app.data.DataConstants
import com.rankmi.app.domain.model.FeedbackPeople

data class FeedbackPeopleEntry(
    @SerializedName(DataConstants.FIRST_NAME) val firstName: String,
    @SerializedName(DataConstants.MIDDLE_NAME) val middleName: String,
    @SerializedName(DataConstants.LAST_NAME) val lastName: String,
    @SerializedName(DataConstants.MOTHERS_NAME) val mothersName: String,
    val avatar: String,
    val position: String
)

fun FeedbackPeopleEntry.toFeedbackPeople() = FeedbackPeople(
    firstName = firstName,
    middleName = middleName,
    lastName= lastName,
    motherName = mothersName,
    avatar = avatar,
    position = position
)