package com.example.candycrushsaga.uiltel


import android.annotation.SuppressLint
import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

open class OnSwipeListener(context: Context?): View.OnTouchListener{

    var gestureDelector :GestureDetector

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(p0: View?, motionEvent: MotionEvent?): Boolean {
        // Check if motionEvent is not null before passing it to gestureDetector
        return motionEvent?.let { gestureDelector.onTouchEvent(it) } ?: false
    }

    inner class GestureListener : GestureDetector.SimpleOnGestureListener(){

        val SWIPE_THRESOLD = 100
        val SWIPE_VELOCITY_THRESOLD = 100

        override  fun onDown(e: MotionEvent): Boolean
        {
            return true

        }

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            var result = false

            e1?.let { event1 ->
                val yDiff = e2.y - event1.y
                val xDiff = e2.x - event1.x

                if (Math.abs(xDiff) > Math.abs(yDiff)) {
                    if (Math.abs(xDiff) > SWIPE_THRESOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESOLD) {
                        if (xDiff > 0) {
                            onSwipeRight()
                        } else {
                            onSwipeLift()
                        }
                        result = true
                    }
                } else if
                               (Math.abs(yDiff) > SWIPE_THRESOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESOLD) {
                    if (yDiff > 0) {
                        onSwipeTop()
                    } else {
                        onSwipeBottom()
                    }
                    result = true
                }

            }

            return result
        }

    }

    open fun onSwipeBottom() {
    }

    open fun onSwipeTop() {
    }

    open fun onSwipeLift() {
    }

    open fun onSwipeRight() {
    }

    init {
        gestureDelector= GestureDetector(context, GestureListener())
    }
}
