package com.example.numfac.presenter

import android.annotation.SuppressLint
import android.util.Log
import com.example.numfac.model.NumFacModel
import com.example.numfac.view.fragments.DateView
import io.reactivex.rxkotlin.subscribeBy

class DateDetailPresenter(private val model: NumFacModel, private val view: DateView) {

    @SuppressLint("CheckResult")
    fun getDateInfo(numDate: Int?) {
        if (numDate != null) {
            Log.v("DateDetailPresenter", "Working on it")
            model.getDateInfo(numDate)
                .doOnSubscribe { view.showProgress() }
                .doAfterTerminate { view.hideProgress() }
                .subscribeBy(onSuccess = {
                    Log.v("DateDetailPresenter", "Got it")
                    view.showDate(it)
                    view.showMonth(it)
                    view.showFact(it)
                }, onError = {
                    Log.v("DateDetailPresenter", "Error" + it.message)
                    it.message?.let{view.showError(it)}
                })
        }
    }
}
