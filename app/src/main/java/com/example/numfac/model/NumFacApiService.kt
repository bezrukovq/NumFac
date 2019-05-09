package com.example.numfac.model

import com.example.numfac.entity.Date
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NumFacApiService{
    @GET("{numDate}/date?json")
    fun getDateInfo(@Path("numDate") numDate: Int): Deferred<Response<Date>>
}
