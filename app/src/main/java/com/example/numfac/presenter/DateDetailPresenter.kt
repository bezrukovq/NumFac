package com.example.numfac.presenter

import android.annotation.SuppressLint
import android.util.Log
import com.example.numfac.entity.Date
import com.example.numfac.model.NumFacModel
import com.example.numfac.view.fragments.DateView
import io.reactivex.rxkotlin.subscribeBy

open class DateDetailPresenter(val model: NumFacModel, val view: DateView) {

    @SuppressLint("CheckResult")
    fun getDateInfo(numDate: Int?) {
        Log.v("DateDetailPresenter", "Working on it")
        model.getDateInfo(numDate)
            .doOnSubscribe { view.showProgress() }
            .doAfterTerminate { view.hideProgress() }
            .subscribeBy(onSuccess = {
                Log.v("DateDetailPresenter", "Got it")
                view.showFac(it)
            }, onError = {
                Log.v("DateDetailPresenter", "Error" + it.message)
                view.showFac(Date(it.message, "", 1, false, "", "1", "jan"))
            })
    }
}
