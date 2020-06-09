package com.example.kotlin_app_two.data

data class Quote (
    val quoteText: String,
    val author: String
) {
    override fun toString(): String {
        return "$quoteText - $author"
    }
}