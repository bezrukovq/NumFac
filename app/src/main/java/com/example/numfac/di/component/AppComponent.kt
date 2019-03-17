package com.example.numfac.di.component

import android.content.Context
import com.example.numfac.di.module.ServiceModule
import com.example.numfac.di.module.NetModule
import com.example.numfac.di.module.AppModule
import com.example.numfac.model.NumFacApiService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    ServiceModule::class])
interface AppComponent {

    fun provideApp(): Context

    fun numFacApiService(): NumFacApiService
}
