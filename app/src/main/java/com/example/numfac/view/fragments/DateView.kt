package com.example.numfac.view.fragments

import com.arellomobile.mvp.MvpView
import com.example.numfac.entity.Date

interface DateView: MvpView {
    fun showDate(date: Date)
    fun showMonth(date: Date)
    fun showFact(date: Date)
    fun showError(string: String)
    fun showProgress()
    fun hideProgress()
}
