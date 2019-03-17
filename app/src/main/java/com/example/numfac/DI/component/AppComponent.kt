package com.example.numfac.DI.component

import android.content.Context
import com.example.numfac.DI.module.ServiceModule
import com.example.numfac.DI.module.NetModule
import com.example.numfac.DI.module.AppModule
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

    fun NumFacApiService(): NumFacApiService

}