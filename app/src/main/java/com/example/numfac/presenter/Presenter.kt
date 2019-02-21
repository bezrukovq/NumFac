package com.example.numfac.presenter

import android.annotation.SuppressLint
import com.example.numfac.model.NumFacModel
import com.example.numfac.view.View
import io.reactivex.rxkotlin.subscribeBy

open class DatePresenter(val model: NumFacModel,val view:View){

    @SuppressLint("CheckResult")
    fun getDateInfo(numDate: Int) {
        model.getDateInfo(numDate).subscribeBy( onSuccess = {
             view.showFac(it[0])
        }, onError = {})
    }
}
