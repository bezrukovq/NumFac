package com.example.numfac.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.numfac.model.NumFacModel
import com.example.numfac.view.fragments.favList.FavListView

@InjectViewState
class FavListPresenter(private val model: NumFacModel) : MvpPresenter<FavListView>() {

    //TODO get list from DB
    fun setDateList() =
        viewState.showDateList(model.getDateList())

    fun openDate(int: Int) {
        viewState.openDate(int)
    }
}
