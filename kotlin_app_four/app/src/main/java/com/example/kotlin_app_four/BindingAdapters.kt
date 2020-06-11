package com.example.kotlin_app_four

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("logoIcon")
fun logoIcon(view: ImageView, logo: LogoMark) {
    when (logo) {
        LogoMark.LOG01 -> {
            view.setImageDrawable(ContextCompat.getDrawable(view.context, R.drawable.ic_launcher_background))
        }
        else -> {
            view.setImageDrawable(ContextCompat.getDrawable(view.context, R.drawable.ic_launcher_foreground))
        }
    }
}