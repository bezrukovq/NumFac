package com.example.numfac.presenter

import android.annotation.SuppressLint
import android.util.Log
import com.example.numfac.entity.Date
import com.example.numfac.model.NumFacModel
import com.example.numfac.view.View
import io.reactivex.rxkotlin.subscribeBy

open class Presenter(val model: NumFacModel, val view: View) {

    @SuppressLint("CheckResult")
    fun getDateInfo(numDate: Int?) {
        Log.v("Presenter", "Working on it")
        model.getDateInfo(numDate)
            .doOnSubscribe { view.showProgress() }
            .doAfterTerminate { view.hideProgress() }
            .subscribeBy(onSuccess = {
            Log.v("Presenter", "Got it")
            view.showFac(it)
        }, onError = {
            Log.v("Presenter", "Error" + it.message)
            view.showFac(Date(it.message, "", 1, false, "","1","jan"))
        })
    }
}
