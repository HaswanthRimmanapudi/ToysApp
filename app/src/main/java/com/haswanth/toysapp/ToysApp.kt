package com.haswanth.toysapp

import android.app.Application
import com.google.firebase.FirebaseApp

class ToysApp : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}