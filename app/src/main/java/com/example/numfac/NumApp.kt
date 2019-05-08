package com.example.numfac

import android.app.Application
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.NavigatorHolder

class  NumApp : Application() {
    private lateinit var cicerone: Cicerone<Router>

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        cicerone = Cicerone.create()
    }

    fun getNavigatorHolder(): NavigatorHolder =
        cicerone.navigatorHolder

    fun getRouter(): Router =
        cicerone.router

    companion object {
        lateinit var INSTANCE: NumApp
    }
}
