package com.example.kotlin_app_four

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
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
            textOne.setText(counterA.toString())
            viewModel.counterB.value = viewModel.counterB.value!! + 1
        }

        val countObserver = Observer<Int> { counter ->
            textTwo.text = counter.toString()
        }
        viewModel.counterB.observe(this, countObserver)

        navigationButton.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }
    }
}