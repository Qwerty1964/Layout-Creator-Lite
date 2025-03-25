package co.benveli.layoutcreator.Activitys.Funs.ZLFuns

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import android.widget.TextView
import co.benveli.layoutcreator.Activitys.ZomLayout

fun ZomLayout.VisibilityorProduct(boolean: Boolean) {
    val transition = AutoTransition()
    transition.duration = 1000

    TransitionManager.beginDelayedTransition(elementosZoomBinding.linear1, transition)
    TransitionManager.beginDelayedTransition(elementosZoomBinding.linear2, transition)

    if (visibleOrInvisibleProduct ) {
        fadeOutTextView(elementosZoomBinding.textTop1)
        fadeOutTextView(elementosZoomBinding.textTop2)
        fadeOutTextView(elementosZoomBinding.viewRight)
        fadeOutTextView(elementosZoomBinding.viewLeft)
        fadeOutTextView(elementosZoomBinding.viewTop)

        elementosZoomBinding.linear1.visibility = View.INVISIBLE
        elementosZoomBinding.linear2.visibility = View.INVISIBLE
        elementosZoomBinding.alturaView1.visibility = View.INVISIBLE
        elementosZoomBinding.nomeView3.visibility = View.INVISIBLE
        elementosZoomBinding.larguraView2.visibility = View.INVISIBLE

        if (boolean) visibleOrInvisibleProduct = false

        elementosZoomBinding.auxiliar1.isClickable = false

    } else {
        fadeInTextView(elementosZoomBinding.textTop1)
        fadeInTextView(elementosZoomBinding.textTop2)
        fadeInTextView(elementosZoomBinding.viewRight)
        fadeInTextView(elementosZoomBinding.viewLeft)
        fadeInTextView(elementosZoomBinding.viewTop)

        elementosZoomBinding.linear1.visibility = View.VISIBLE
        elementosZoomBinding.linear2.visibility = View.VISIBLE
        elementosZoomBinding.alturaView1.visibility = View.VISIBLE
        elementosZoomBinding.nomeView3.visibility = View.VISIBLE
        elementosZoomBinding.larguraView2.visibility = View.VISIBLE

        if (boolean) visibleOrInvisibleProduct = true

        elementosZoomBinding.auxiliar1.isClickable = true

    }
}