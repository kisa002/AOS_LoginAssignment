package com.haeyum.loginassignment

import android.widget.Toast

class ToastHelper {
    companion object {
        fun showToast(msg: String) {
            Toast.makeText(MainApp.context, msg, Toast.LENGTH_SHORT).show()
        }
    }
}