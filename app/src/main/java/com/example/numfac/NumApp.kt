package com.example.numfac

import android.app.Application
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.NavigatorHolder

class NumApp : Application() {
    private lateinit var cicerone: Cicerone<Router>

    override fun onCreate() {
        super.onCreate()
        cicerone = Cicerone.create()
    }

    fun getNavigatorHolder(): NavigatorHolder {
        return cicerone.navigatorHolder
    }

    fun getRouter(): Router {
        return cicerone.router
    }
    companion object {
        lateinit var INSTANCE: NumApp
    }
}