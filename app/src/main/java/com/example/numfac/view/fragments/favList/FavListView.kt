package com.example.numfac.view.fragments.favList

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.numfac.entity.DateDB

interface FavListView : MvpView {
    @StateStrategyType(value = SkipStrategy::class)
    fun openDate(dateDB: DateDB)
    fun showDateList(dataList: List<DateDB>)
}
