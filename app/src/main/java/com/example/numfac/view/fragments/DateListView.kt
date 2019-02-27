package com.example.numfac.view.fragments

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndStrategy::class)
interface DateListView : MvpView {
    //@StateStrategyType(value = SkipStrategy::class)
    fun showDateList(dataList: ArrayList<Int>)

    fun expandDateList(dataList: ArrayList<Int>)
    @StateStrategyType(value = SkipStrategy::class)
    fun openDate(num: Int)
}
