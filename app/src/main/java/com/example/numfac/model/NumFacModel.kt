package com.example.numfac.model

import android.content.Context
import androidx.room.Room
import com.example.numfac.entity.Date
import com.example.numfac.entity.DateDB
import com.example.numfac.model.DB.AppDataBase
import com.example.numfac.model.DB.DateRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

object NumFacModel {

    private const val COUNTER = 15
    private const val LAST_DATE = 365
    private var curNumber = 0

    val numApi: NumFacApiService = ApiFactory.createApi()
    lateinit var db: AppDataBase
    lateinit var dateRepository: DateRepository

    fun setDB(applicationContext: Context) {
        db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "database"
        )
            .build()
        dateRepository = DateRepository(db.dateDao())
    }

    fun getFavDateList(): Single<List<DateDB>> =
        dateRepository.getAllDates()

    fun addToFavList(dateDB: DateDB) =
        dateRepository.addDate(dateDB).subscribe()

    fun deleteFromFavList(dateDB: DateDB) =
        dateRepository.deleteDate(dateDB).subscribe()

    fun getDateInfo(numDate: Int): Single<Date> =
        numApi.getDateInfo(numDate)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getDateList(): ArrayList<Int> {
        val list = ArrayList<Int>()
        val today = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        for (item: Int in today..today + COUNTER)
            list.add(item)
        curNumber = today + COUNTER + 1
        return list
    }

    fun expandDateList(itemsCount: Int): ArrayList<Int> {
        val list = ArrayList<Int>()
        for (item: Int in curNumber..curNumber + itemsCount) {
            if (curNumber <= LAST_DATE)
                list.add(item)
        }
        curNumber += itemsCount + 1
        return list
    }
}
