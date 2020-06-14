package com.example.kotlin_app_original_one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.kotlin_app_original_one.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val quiz: Quiz = Quiz(
            id = 1,
            title = "Game",
            description = "What is the game title from Square Enix?",
            proposedAnswerList = arrayOf<String>("BioHazard", "StarOcean", "FinalFantasy", "SuperMario"),
            answerIndex = 3
        )
        binding.quiz = quiz
    }
}