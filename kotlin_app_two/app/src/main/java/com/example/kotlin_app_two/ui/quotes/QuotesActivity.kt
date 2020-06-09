package com.example.kotlin_app_two.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_app_two.R
import com.example.kotlin_app_two.data.Quote
import kotlinx.android.synthetic.main.activity_main.*

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeActivity()
    }

    private fun initializeActivity() {
        val viewModel = ViewModelProvider(this).get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuffer = StringBuffer()
            quotes.forEach { quote -> stringBuffer.append("${quote}\n") }
            textView_quotes.text = stringBuffer.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}