package com.haeyum.loginassignment.statusBarManager

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import com.haeyum.loginassignment.R

class StatusBarManager {
    companion object {
        fun getStatusBarHeight(activity: Activity): Int {
            val rectangle = Rect()
            val window = activity.window

            window.decorView.getWindowVisibleDisplayFrame(rectangle)

            val statusBarHeight = rectangle.top
            val contentViewTop = window.findViewById<View>(Window.ID_ANDROID_CONTENT).top
            val titleBarHeight = contentViewTop - statusBarHeight

            return statusBarHeight
        }

        fun View.margin(left: Float? = null, top: Float? = null, right: Float? = null, bottom: Float? = null) {
            layoutParams<ViewGroup.MarginLayoutParams> {
                left?.run { leftMargin = dpToPx(this) }
                top?.run { topMargin = dpToPx(this) }
                right?.run { rightMargin = dpToPx(this) }
                bottom?.run { bottomMargin = dpToPx(this) }
            }
        }

        inline fun <reified T : ViewGroup.LayoutParams> View.layoutParams(block: T.() -> Unit) {
            if (layoutParams is T) block(layoutParams as T)
        }

        fun View.dpToPx(dp: Float): Int = context.dpToPx(dp)
        fun Context.dpToPx(dp: Float): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()

        fun changeStatusBarTransparentWithWhiteText(window: Window) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.statusBarColor = Color.TRANSPARENT
        }
        fun changeStatusBarTransparentWithBlackText(window: Window) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = Color.TRANSPARENT
        }

        fun changeStatusBarTransparent(window: Window, view: View) {
            val resId = window.context.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resId > 0) {
                val statusBarHeight = window.context.resources.getDimensionPixelSize(resId)
                view.margin(top = statusBarHeight.toFloat())
                changeStatusBarTransparentWithBlackText(window)
            }
        }

        fun setStatusBarColor(window: Window, context: Context, colorId: Int) {
            window.statusBarColor = ContextCompat.getColor(context, colorId)
        }

        fun changeStatusBarTextColorBack(window: Window) {
            window.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        fun changeStatusBarTextColorWhite(window: Window) {
            window.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }

        fun changeStatusBarColorWhite(window: Window, context: Context) {
            setStatusBarColor(window, context, R.color.white)
            changeStatusBarTextColorBack(window)
        }
    }
}