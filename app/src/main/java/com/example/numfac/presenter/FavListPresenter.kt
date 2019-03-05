package com.example.numfac.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.numfac.entity.DateDB
import com.example.numfac.model.NumFacModel
import com.example.numfac.view.fragments.favList.FavListView
import io.reactivex.rxkotlin.subscribeBy

@InjectViewState
class FavListPresenter(private val model: NumFacModel) : MvpPresenter<FavListView>() {

    fun setDateList() =
        model.getFavDateList()?.subscribeBy(onSuccess = {
            viewState.showDateList(it)
        })

    fun openDate(dateDB: DateDB) =
        viewState.openDate(dateDB)
}
