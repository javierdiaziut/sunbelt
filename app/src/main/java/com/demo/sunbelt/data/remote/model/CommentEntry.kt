package com.rankmi.app.data.remote.model

import com.rankmi.app.domain.model.Comment

data class CommentEntry(
    val user: FeedbackPeopleEntry,
    val comment: String
)

fun CommentEntry.toComment() = Comment(
    user = user.toFeedbackPeople(),
    comment = comment
)