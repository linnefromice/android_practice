package com.example.kotlin_app_original_one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
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
            answerIndex = 2
        )
        binding.quiz = quiz
        addActionToButtons(quiz)
    }

    private fun addActionToButtons(quiz: Quiz) {
        val correctAnswer: String = quiz.proposedAnswerList[quiz.answerIndex]
        binding.buttonOne.setOnClickListener { createResultToast(quiz.proposedAnswerList[0], correctAnswer)}
        binding.buttonTwo.setOnClickListener { createResultToast(quiz.proposedAnswerList[1], correctAnswer)}
        binding.buttonThree.setOnClickListener { createResultToast(quiz.proposedAnswerList[2], correctAnswer)}
        binding.buttonFour.setOnClickListener { createResultToast(quiz.proposedAnswerList[3], correctAnswer)}
    }

    private fun createResultToast(answer: String, correctAnswer: String) {
        if (answer == correctAnswer) {
            Toast.makeText(applicationContext, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "Incorrect...", Toast.LENGTH_SHORT).show()
        }
    }
}