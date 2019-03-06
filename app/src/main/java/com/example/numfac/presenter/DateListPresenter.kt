package com.example.numfac.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.numfac.model.NumFacModel
import com.example.numfac.view.fragments.dateList.DateListView

@InjectViewState
class DateListPresenter(private val model: NumFacModel) : MvpPresenter<DateListView>() {

    fun setDateList() =
        viewState.showDateList(model.getDateList())

    fun expendDateList(itemsCount: Int) =
        viewState.expandDateList(model.expandDateList(itemsCount))

    fun openDate(int: Int) =
        viewState.openDate(int)
}
