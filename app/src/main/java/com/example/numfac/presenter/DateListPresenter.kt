package com.example.numfac.presenter

import com.example.numfac.model.NumFacModel
import com.example.numfac.view.fragments.DateListView

class DateListPresenter(private val model: NumFacModel,private val view: DateListView) {

    fun setDateList() =
        view.showDateList(model.getDateList())

}
