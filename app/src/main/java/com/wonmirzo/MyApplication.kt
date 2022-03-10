package com.wonmirzo

import android.app.Application


class MyApplication : Application() {
    companion object {
        private val TAG = MyApplication::class.java.simpleName
        var instance: MyApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}