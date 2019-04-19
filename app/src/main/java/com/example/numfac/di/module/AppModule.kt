package com.example.numfac.di.module

import android.app.Application
import android.content.Context
import com.example.numfac.NumApp
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideApp(): Context = app

    @Provides
    @Singleton
    fun provideRouter(): Router =
        NumApp.INSTANCE.getRouter()
}
