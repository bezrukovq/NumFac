package com.example.numfac.DI.module

import com.example.numfac.model.NumFacApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideComicsService(retrofit: Retrofit): NumFacApiService =
        retrofit.create(NumFacApiService::class.java)
}