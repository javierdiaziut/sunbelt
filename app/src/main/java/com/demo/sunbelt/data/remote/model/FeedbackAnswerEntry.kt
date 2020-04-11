package com.rankmi.app.data.remote.model

import com.rankmi.app.domain.model.FeedbackAnswer
import kotlin.collections.ArrayList

data class FeedbackAnswerEntry(

    val id: Int,
    val answer_type : String,
    val option: String,
    val question: String,
    val content: String,
    val options: ArrayList<OptionAnswerEntry>?
)

fun FeedbackAnswerEntry.toFeedbackAnswer() = FeedbackAnswer(
    id =id,
    answer_type = answer_type,
    option = option,
    content = content,
    question = question
)