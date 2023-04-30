package com.example.floatinganimation

import android.view.animation.Animation
import android.view.animation.TranslateAnimation

object FloatingAnimation {
    val anim = TranslateAnimation(0F, 0F, 0F, -20F).apply {
        duration = 1000
        repeatMode = Animation.REVERSE
        repeatCount = Animation.INFINITE
    }
}