package com.example.numfac.presenter

import android.annotation.SuppressLint
import android.util.Log
import com.example.numfac.model.NumFacModel
import com.example.numfac.view.View
import io.reactivex.rxkotlin.subscribeBy

open class Presenter(val model: NumFacModel,val view:View){

    @SuppressLint("CheckResult")
    fun getDateInfo(numDate: Int) {
        Log.v("Presenter","Working on it")
        model.getDateInfo(numDate).subscribeBy( onSuccess = {
            Log.v("Presenter","Got it")

            view.showFac(it[0])
        }, onError = {        Log.v("Presenter","Error"+it.message)
        })
    }
}
