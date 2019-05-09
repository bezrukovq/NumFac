package com.example.numfac.model

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val URL = "http://numbersapi.com/"

    fun createApi(): NumFacApiService {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory( CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(URL)
            .build()
        return retrofit.create(NumFacApiService::class.java)
    }
}
