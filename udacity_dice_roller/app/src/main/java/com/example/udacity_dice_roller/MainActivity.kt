package com.example.udacity_dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roll_button.text = "Let's Roll"
        roll_button.setOnClickListener {
            // 1-17
            // Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
            rolLDice()
        }
    }

    private fun rolLDice() {
        val randomInt: Int = Random().nextInt(6) + 1
        result_text.text = randomInt.toString()
    }
}