package com.example.kotlin_app_four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 比較用のアクティビティに属するカウンター
        var counterA = 0
        // インスタンスを作成
        val viewModel: CountViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)

        countButton.setOnClickListener {
            counterA++
            viewModel.counterB++

            textOne.setText(counterA.toString())
            textTwo.setText(viewModel.counterB.toString())
        }
    }
}