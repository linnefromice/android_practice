package com.example.kotlin_app_four

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {
    val counterB: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    init {
        counterB.value = 0
    }
}