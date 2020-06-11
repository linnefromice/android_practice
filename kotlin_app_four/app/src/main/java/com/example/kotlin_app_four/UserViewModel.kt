package com.example.kotlin_app_four

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    // LiveDataを作成
    val user: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }

    val logo: LiveData<LogoMark> = Transformations.map(user) {
        when {
            user.value!!.age > 40 -> LogoMark.LOG01
            else -> LogoMark.LOG02
        }
    }

    init {
        user.value = User("SUZUKI", 45)
    }

    fun change() {
        user.value = User("OHTANI", 25)
    }
}

enum class LogoMark {
    LOG01, LOG02
}