package com.example.numfac.model

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import com.example.numfac.entity.Date
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class NumFacModel{

    val numApi: NumFacApiService=ApiFactory.createApi()

    fun getDateInfo(numDate: Int): Single<Date> =
        numApi.getDateInfo(numDate)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getDateList(): List<Int>{
        val list = ArrayList<Int>()
        val today = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        for (item: Int in today..today + COUNTER)
            list.add(item)
        curNumber = today + COUNTER
        return list
    }

    fun expandDateList(): List<Int>{
        val list = ArrayList<Int>()
        for (item: Int in curNumber..curNumber + PAGE_SIZE)
            list.add(item)
        curNumber += PAGE_SIZE
        return list
    }

    companion object {
        private const val COUNTER = 9
        private var curNumber = 0
    }
}
