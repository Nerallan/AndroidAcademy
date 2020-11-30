package by.androidacademy.nerallan.ext

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.setOnClickAction(action: (() -> Unit)?) {
    isClickable = if (action != null) {
        setOnClickListener { action() }
        true
    } else {
        setOnClickListener(null)
        false
    }
}

fun <T> View.setOnClickAction(value: T, action: ((value: T) -> Unit)?) {
    isClickable = if (action != null) {
        setOnClickListener { action(value) }
        true
    } else {
        setOnClickListener(null)
        false
    }
}

fun View.showKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    this.requestFocus()
    imm.showSoftInput(this, 0)
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.dip2px(dp: Float): Float {
    return dp * resources.displayMetrics.density
}
