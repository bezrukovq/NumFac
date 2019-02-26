package com.example.numfac.view.fragments

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy)
 interface DateListView: MvpView {
    fun showDateList(dataList: List<Int>)
}
