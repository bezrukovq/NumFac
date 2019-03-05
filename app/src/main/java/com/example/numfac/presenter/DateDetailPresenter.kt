package com.example.numfac.presenter

import android.annotation.SuppressLint
import android.util.Log
import androidx.annotation.VisibleForTesting
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.numfac.entity.DateDB
import com.example.numfac.model.NumFacModel
import com.example.numfac.view.fragments.DateView
import io.reactivex.rxkotlin.subscribeBy

@InjectViewState
class DateDetailPresenter(private val model: NumFacModel): MvpPresenter<DateView>() {

    fun saveToFav(dateDB: DateDB) =
        model.addToFavList(dateDB)

    fun deleteFromFav(dateDB: DateDB) =
        model.deleteFromFavList(dateDB)

    @VisibleForTesting
    @SuppressLint("CheckResult")
    fun getDateInfo(numDate: Int?) {
        if (numDate != null) {
            model.getDateInfo(numDate)
                .doOnSubscribe { viewState.showProgress() }
                .doAfterTerminate { viewState.hideProgress() }
                .subscribeBy(onSuccess = {
                    viewState.showDate(it)
                    viewState.showMonth(it)
                    viewState.showFact(it)
                }, onError = {
                    viewState.showError("smth go wrong")
                })
        }
    }
}
