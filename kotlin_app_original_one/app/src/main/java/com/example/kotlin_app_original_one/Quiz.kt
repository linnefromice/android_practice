package com.example.kotlin_app_original_one

data class Quiz (
    val id: Int,
    val title: String,
    val description: String,
    val proposedAnswerList: Array<String>,
    val answerIndex: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Quiz

        if (id != other.id) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (!proposedAnswerList.contentEquals(other.proposedAnswerList)) return false
        if (answerIndex != other.answerIndex) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + proposedAnswerList.contentHashCode()
        result = 31 * result + answerIndex
        return result
    }
}