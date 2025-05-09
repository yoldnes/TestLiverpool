package com.example.testliverpool.common

import android.os.SystemClock
import android.view.View

private const val DEFAULT_DEBOUNCED_INTERVAL = 300L

fun View.setOnDebouncedClickListener(
    interval: Long = DEFAULT_DEBOUNCED_INTERVAL,
    onClick: (View) -> Unit,
) {
    var lastClickTime = 0L
    this.setOnClickListener { view ->
        val currentTime = SystemClock.elapsedRealtime()
        if (currentTime - lastClickTime < interval) {
            return@setOnClickListener
        }
        lastClickTime = currentTime
        onClick(view)
    }
}

internal fun View.show() {
    visibility = View.VISIBLE
}

internal fun View.hide() {
    visibility = View.GONE
}
