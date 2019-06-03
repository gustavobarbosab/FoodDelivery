package com.gustavobarbosa.fooddelivery.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View

fun View.showView(timeMillis: Long) {
    if (visibility != View.VISIBLE) {
        animate()
            .alpha(1f)
            .setDuration(timeMillis)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    visibility = View.VISIBLE
                }
            })
    }
}

fun View.hideView(timeMillis: Long) {
    if (visibility == View.VISIBLE) {
        animate()
            .alpha(0f)
            .setDuration(timeMillis)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    visibility = View.GONE
                }
            })
    }
}