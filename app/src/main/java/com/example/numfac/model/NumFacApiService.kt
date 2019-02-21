package com.example.numfac.model

import com.example.numfac.entity.Date
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface NumFacApiService{
    @GET("{num1}..{num2}/data?json")
    fun search(@Path("num1") num1: Int,
               @Path("num2") num2: Int): Observable<List<Date>>
}
