package com.example.numfac.presenter

import com.example.numfac.model.NumFacModel
import com.example.numfac.view.fragments.DateListView

open class DateListPresenter(val model: NumFacModel, val view: DateListView) {

    fun setDateList() {
        view.showDateList(model.getDateList())
    }
}
