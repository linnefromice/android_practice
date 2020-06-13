package com.example.udacity_about_me

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        done_button.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(it: View) {
        nickname_text.text = nickname_edit.text
        nickname_edit.visibility = View.GONE
        done_button.visibility = View.GONE
        nickname_text.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it.windowToken, 0)
    }
}