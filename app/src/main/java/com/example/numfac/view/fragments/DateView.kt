package com.example.numfac.view.fragments

import com.example.numfac.entity.Date

interface DateView {
    fun showDate(date: Date)
    fun showMonth(date: Date)
    fun showFact(date: Date)
    fun showError(string: String)
    fun showProgress()
    fun hideProgress()
}
