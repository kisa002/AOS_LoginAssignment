package com.haeyum.loginassignment

import android.content.Context

class AppPref(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("data", Context.MODE_PRIVATE)

    private val KEY_USERNAME = "KEY_USERNAME"
    private val KEY_PASSWORD = "KEY_PASSWORD"

    var username: String?
        get() = sharedPreferences.getString(KEY_USERNAME, null)
        set(value) {
            sharedPreferences.edit().putString(KEY_USERNAME, value).commit()
        }

    var password: String?
        get() = sharedPreferences.getString(KEY_PASSWORD, null)
        set(value) {
            sharedPreferences.edit().putString(KEY_PASSWORD, value).commit()
        }
}