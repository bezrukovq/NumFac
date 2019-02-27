package com.example.numfac.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.numfac.model.NumFacModel
import com.example.numfac.view.fragments.DateListView

@InjectViewState
class DateListPresenter(private val model: NumFacModel) : MvpPresenter<DateListView>() {

    fun setDateList() =
        viewState.showDateList(model.getDateList())

    fun expendDateList() =
        viewState.expandDateList(model.expandDateList())

    fun openDate(int: Int) {
        viewState.openDate(int)
    }
}
