package com.githab.laravish.lessonmvp

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val router = cicerone.router
    val navigatorHolder = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}