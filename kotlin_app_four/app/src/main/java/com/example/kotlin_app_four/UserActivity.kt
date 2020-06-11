package com.example.kotlin_app_four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.kotlin_app_four.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        // ViewModelのインスタンスを作成
        val viewModel: UserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        // DataBindingのインスタンスを作成(onCreateの外でも良い)
        val binding: ActivityUserBinding = DataBindingUtil.setContentView(this, R.layout.activity_user)
        // ViewModelのインスタンスを設定
        binding.userViewModel = viewModel
        // ライフサイクル所有者を設定
        binding.lifecycleOwner = this
    }
}