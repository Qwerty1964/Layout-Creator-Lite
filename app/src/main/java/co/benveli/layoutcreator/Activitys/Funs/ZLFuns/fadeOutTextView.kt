package co.benveli.layoutcreator.Activitys.Funs.ZLFuns

import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.widget.TextView

fun fadeOutTextView(textView: TextView) {
    if (textView.visibility == View.INVISIBLE) return

    val animationDuration = 1000L

    val fadeOut = AlphaAnimation(1f, 0f)
    fadeOut.interpolator = AccelerateInterpolator()
    fadeOut.duration = animationDuration

    val animation = AnimationSet(false)
    animation.addAnimation(fadeOut)

    animation.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {}
        override fun onAnimationEnd(animation: Animation?) {
            textView.visibility = View.INVISIBLE
        }
        override fun onAnimationRepeat(animation: Animation?) {}
    })
    textView.startAnimation(animation)
}