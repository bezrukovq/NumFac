package com.example.numfac.view.fragments.favList

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.numfac.entity.DateDB

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FavListView : MvpView {
    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun showDateList(dataList: List<DateDB>)
}
