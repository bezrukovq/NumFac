package com.example.numfac.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.numfac.model.NumFacModel
import com.example.numfac.view.fragments.DateListView

@InjectViewState
class DateListPresenter(private val model: NumFacModel,private val view: DateListView): MvpPresenter<DateListView>() {

    fun setDateList() =
        view.showDateList(model.getDateList())

}
