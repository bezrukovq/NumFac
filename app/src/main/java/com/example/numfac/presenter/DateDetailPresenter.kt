package com.example.numfac.presenter

import android.annotation.SuppressLint
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.numfac.entity.DateDB
import com.example.numfac.model.NumFacModel
import com.example.numfac.view.fragments.DateView
import io.reactivex.rxkotlin.subscribeBy

@InjectViewState
class DateDetailPresenter(private val model: NumFacModel) : MvpPresenter<DateView>() {
    private var isLiked = false

    fun saveToFav(dateDB: DateDB) =
        model.addToFavList(dateDB)

    fun deleteFromFav(dateDB: DateDB) =
        model.deleteFromFavList(dateDB)

    fun likePressed(text: String) {
        if (!isLiked) {
            isLiked = true
            saveToFav(DateDB(text))
            viewState.like()
        } else {
            isLiked = false
            deleteFromFav(DateDB(text))
            viewState.unlike()
        }
    }

    @SuppressLint("CheckResult")
    fun getDateInfo(numDate: Int?) {
        if (numDate != null) {
            Log.v("DateDetailPresenter", "Working on it")
            model.getDateInfo(numDate)
                .doOnSubscribe { viewState.showProgress() }
                .doAfterTerminate { viewState.hideProgress() }
                .subscribeBy(onSuccess = {
                    Log.v("DateDetailPresenter", "Got it")
                    viewState.showDate(it)
                    viewState.showMonth(it)
                    viewState.showFact(it)
                }, onError = {
                    Log.v("DateDetailPresenter", "Error" + it.message)
                    it.message?.let { viewState.showError(it) }
                })
        }
    }

    fun showCached(text: String) {
        isLiked=true
        viewState.showCached(text)
    }

    fun checkCached(cached: Boolean?, text: String, number: Int?) {
        if (cached != null && cached)
            showCached(text)
        else
            getDateInfo(number)
    }
}
