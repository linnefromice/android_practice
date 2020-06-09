package com.example.kotlin_app_two.ui.quotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_app_two.data.FakeDatabase
import com.example.kotlin_app_two.data.Quote
import com.example.kotlin_app_two.data.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// QuoteRepository dependency will again be passed in the constructor using dependency injection
class QuotesViewModel : ViewModel() {
    private val quoteRepository: QuoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
    private val quotes: LiveData<List<Quote>>

    init {
        quotes = quoteRepository.getQuotes()
    }

    fun getQuotes() = quotes
    fun addQuote(quote: Quote) = viewModelScope.launch(Dispatchers.IO) {
        quoteRepository.addQuote(quote)
    }
}