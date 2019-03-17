package com.example.numfac.di.module

import com.example.numfac.model.NumFacApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideNumFacApiService(retrofit: Retrofit): NumFacApiService =
        retrofit.create(NumFacApiService::class.java)
}
