package com.example.numfac.model.DB

import com.example.numfac.entity.DateDB
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DateRepository(val dateDAO: DateDAO?) {

    fun addDate(dateDB: DateDB) =
        Completable.fromAction { dateDAO?.insert(dateDB) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun deleteDate(dateDB: DateDB) =
        Completable.fromAction { dateDAO?.delete(dateDB.text) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getAllDates(): Single<List<DateDB>>? =
        dateDAO?.run {
            getAllFavDates()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
}
