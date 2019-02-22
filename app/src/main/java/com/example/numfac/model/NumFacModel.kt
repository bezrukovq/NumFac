package com.example.numfac.model

import com.example.numfac.entity.Date
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class NumFacModel{

    val numApi: NumFacApiService=createApi()

    fun getDateInfo(numDate: Int): Single<Date> =
        numApi.getDateInfo(numDate)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    companion object {
        fun createApi(): NumFacApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://numbersapi.com/")
                .build()
            return retrofit.create(NumFacApiService::class.java);
        }
    }
}
