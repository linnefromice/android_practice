package com.example.kotlin_app_original_one

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.kotlin_app_original_one.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var EXTRA_KEY = "correct_count_key"
    private var quizList: MutableList<Quiz> = mutableListOf<Quiz>(
        Quiz(
            id = 1,
            title = "Game",
            description = "What is the game title from Square Enix?",
            proposedAnswerList = arrayOf<String>("BioHazard", "StarOcean", "FinalFantasy", "SuperMario"),
            answerIndex = 2
        ),
        Quiz(
            id = 2,
            title = "Game",
            description = "What is the hero from Nintendo?",
            proposedAnswerList = arrayOf<String>("Kuribo", "Wario", "Peach", "Mario"),
            answerIndex = 3
        ),
        Quiz(
            id = 3,
            title = "Game",
            description = "Which word fill this title, XXX brothers, meaning popular game from Nintendo.",
            proposedAnswerList = arrayOf<String>("Smash", "Attack", "Slush", "Crash"),
            answerIndex = 0
        ),
        Quiz(
            id = 4,
            title = "Game",
            description = "What is the game hard name from Sony?",
            proposedAnswerList = arrayOf<String>("Play Station", "Dream Cast", "Nintendo 64", "Sega Saturn"),
            answerIndex = 0
        ),
        Quiz(
            id = 5,
            title = "Game",
            description = "Which weapon is main equipment pf Link?",
            proposedAnswerList = arrayOf<String>("Gun", "Bomb", "Sword", "Spear"),
            answerIndex = 2
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val randomInt = Random.nextInt(quizList.size)
        val quiz: Quiz = quizList[randomInt]
        binding.quiz = quiz

        val correctNumber = intent.extras?.getInt(EXTRA_KEY) ?: 0
        addActionToButtons(quiz, correctNumber)
        correct_count_number.text = correctNumber.toString()
    }

    private fun addActionToButtons(quiz: Quiz, correctNumber: Int) {
        val correctAnswer: String = quiz.proposedAnswerList[quiz.answerIndex]
        binding.buttonOne.setOnClickListener { createResultToast(quiz.proposedAnswerList[0], correctAnswer, correctNumber)}
        binding.buttonTwo.setOnClickListener { createResultToast(quiz.proposedAnswerList[1], correctAnswer, correctNumber)}
        binding.buttonThree.setOnClickListener { createResultToast(quiz.proposedAnswerList[2], correctAnswer, correctNumber)}
        binding.buttonFour.setOnClickListener { createResultToast(quiz.proposedAnswerList[3], correctAnswer, correctNumber)}
    }

    private fun createResultToast(answer: String, correctAnswer: String, correctNumber: Int) {
        val intent = Intent(this@MainActivity, MainActivity::class.java)
        if (answer == correctAnswer) {
            Toast.makeText(applicationContext, "Correct!", Toast.LENGTH_SHORT).show()
            intent.putExtra(EXTRA_KEY, correctNumber + 1)
        } else {
            Toast.makeText(applicationContext, "Incorrect...", Toast.LENGTH_SHORT).show()
            intent.putExtra(EXTRA_KEY, 0)
        }
        startActivity(intent)
    }
}