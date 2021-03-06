package com.example.numfac.model

import com.example.numfac.entity.Date
import com.example.numfac.entity.DateDB
import com.example.numfac.model.DB.DateRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class NumFacModel(val numFacApiService: NumFacApiService,val dateRepository: DateRepository) {

    private var curNumber = 0

    fun getFavDateList(): Single<List<DateDB>>? =
        dateRepository.getAllDates()

    fun addToFavList(dateDB: DateDB) =
        dateRepository.addDate(dateDB)?.subscribe()

    fun deleteFromFavList(dateDB: DateDB) =
        dateRepository.deleteDate(dateDB)?.subscribe()

    fun getDateInfo(numDate: Int): Single<Date> =
        numFacApiService.getDateInfo(numDate)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getDateList(): ArrayList<Int> {
        val list = ArrayList<Int>()
        val today = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        for (item: Int in today..today + Companion.COUNTER)
            list.add(item)
        curNumber = today + Companion.COUNTER + 1
        return list
    }

    fun expandDateList(itemsCount: Int): ArrayList<Int> {
        val list = ArrayList<Int>()
        for (item: Int in curNumber..curNumber + itemsCount) {
            if (curNumber <= Companion.LAST_DATE)
                list.add(item)
        }
        curNumber += itemsCount + 1
        return list
    }

    companion object {
        private const val COUNTER = 15
        private const val LAST_DATE = 365
    }
}
