package com.example.numfac.view.fragments.favList

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface FavListView : MvpView {
    @StateStrategyType(value = SkipStrategy::class)
    fun openDate(num: Int)
    fun showDateList(dataList: ArrayList<Int>)
}
