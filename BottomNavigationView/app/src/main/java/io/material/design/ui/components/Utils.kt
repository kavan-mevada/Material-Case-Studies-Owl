package io.material.design.ui.components

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.view.ViewGroup
import androidx.core.view.animation.PathInterpolatorCompat
import androidx.core.view.children

/** Copyright (C) kavanmevada - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by kavanmevada <kavanmevada@gmail.com> on 20,December,2018
 **/


internal fun View.doBounceAnimation() {
    val mAnimatorSet = AnimatorSet()
    mAnimatorSet.playTogether(
        ObjectAnimator.ofFloat(this, "translationY", 60f,-15f, 0f),
        ObjectAnimator.ofFloat(this, "scaleY",1.3f, 1f)
    )
    if (this is ViewGroup) {
        this.children.forEach {
            mAnimatorSet.playTogether(
                ObjectAnimator.ofFloat(it, "translationY", 60f, -15f, 0f),
                ObjectAnimator.ofFloat(it, "scaleY",.7f, 1f)
            )
        }
    }
    mAnimatorSet.interpolator = PathInterpolatorCompat.create(0.530f, 0.995f)
    mAnimatorSet.startDelay = 100
    mAnimatorSet.duration = 700
    mAnimatorSet.start()
}