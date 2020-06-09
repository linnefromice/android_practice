package com.example.kotlin_app_two.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.kotlin_app_two.data.Quote
import com.example.kotlin_app_two.data.QuoteRepository

// QuoteRepository dependency will again be passed in the constructor using dependency injection
class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}