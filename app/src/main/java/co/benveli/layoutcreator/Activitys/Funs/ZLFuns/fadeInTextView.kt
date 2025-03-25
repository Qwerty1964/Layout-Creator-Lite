package co.benveli.layoutcreator.Activitys.Funs.ZLFuns

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import android.widget.TextView

fun fadeInTextView(textView: TextView) {
    if (textView.visibility == View.VISIBLE) return

    val animationDuration = 1000L

    textView.visibility = View.VISIBLE

    val fadeIn = AlphaAnimation(0f, 1f)
    fadeIn.interpolator = DecelerateInterpolator()
    fadeIn.duration = animationDuration

    val animation = AnimationSet(false)
    animation.addAnimation(fadeIn)

    textView.startAnimation(animation)
}