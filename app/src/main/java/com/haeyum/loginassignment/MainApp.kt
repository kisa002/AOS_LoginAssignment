package com.haeyum.loginassignment

import android.app.Application
import android.content.Context

class MainApp: Application() {
    companion object {
        lateinit var context: Context
        lateinit var appPref: AppPref
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        appPref = AppPref(this)
    }
}