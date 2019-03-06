package com.example.numfac.view.fragments

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.numfac.entity.Date

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface DateView: MvpView {
    fun showDate(date: Date)
    fun showMonth(date: Date)
    fun showFact(date: Date)
    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun showError(string: String)
    fun showProgress()
    fun hideProgress()
    fun like()
    fun unlike()
    fun showCached(text: String)
}
