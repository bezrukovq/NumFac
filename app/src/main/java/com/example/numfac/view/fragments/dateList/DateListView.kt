package com.example.numfac.view.fragments.dateList

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndStrategy::class)
interface DateListView : MvpView {
    //@StateStrategyType(value = SkipStrategy::class)
    fun showDateList(dataList: ArrayList<Int>)

    fun expandDateList(dataList: ArrayList<Int>)
    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun openDate(num: Int)
}
