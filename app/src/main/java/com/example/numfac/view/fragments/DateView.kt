package com.example.numfac.view.fragments

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.numfac.entity.Date

@StateStrategyType(value = AddToEndStrategy::class)
interface DateView: MvpView {
    fun showDate(date: Date)
    fun showMonth(date: Date)
    @StateStrategyType(value = AddToEndStrategy::class)
    fun showFact(date: Date)
    fun showError(string: String)
    fun showProgress()
    fun hideProgress()
}
