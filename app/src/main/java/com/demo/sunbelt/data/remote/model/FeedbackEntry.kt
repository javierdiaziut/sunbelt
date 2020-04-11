package com.rankmi.app.data.remote.model

import com.google.gson.annotations.SerializedName
import com.rankmi.app.data.DataConstants
import com.rankmi.app.data.DataConstants.COMPETENCES_AND_VALUES
import com.rankmi.app.data.DataConstants.FEEDBACK_TYPE
import com.rankmi.app.data.DataConstants.STAR_RATING
import com.rankmi.app.domain.model.Feedback
import com.rankmi.app.domain.model.FeedbackPeople

data class FeedbackEntry(
    val id: Int,
    @SerializedName(FEEDBACK_TYPE) val feedbackType: String,
    val giver: FeedbackPeopleEntry,
    val receiver: FeedbackPeopleEntry,
    val answers: ArrayList<FeedbackAnswerEntry>,
    @SerializedName(STAR_RATING) val starRating: StarRatingEntry,
    @SerializedName(COMPETENCES_AND_VALUES) val competences_and_values: ArrayList<CompetencesValueEntry>,
    val likes: ArrayList<LikesEntry>,
    val comments: ArrayList<CommentEntry>

)

fun FeedbackEntry.toFeedback() = Feedback(
    id = id,
    feedbackType = feedbackType,
    giver = giver.toFeedbackPeople(),
    receiver = receiver.toFeedbackPeople(),
    answers = ArrayList(answers.map { it.toFeedbackAnswer() }),
    starRating = starRating.toStarRating(),
    competencesAndValues = ArrayList(competences_and_values.map { it.toCompetencesValue() }),
    likes = ArrayList(likes.map { it.toLikes() }),
    comments = ArrayList(comments.map { it.toComment() })
)