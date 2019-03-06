package com.example.numfac.view.fragments.dateList

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface DateListView : MvpView {
    //@StateStrategyType(value = SkipStrategy::class)
    fun showDateList(dataList: ArrayList<Int>)

    fun expandDateList(dataList: ArrayList<Int>)
    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun openDate(num: Int)
}
