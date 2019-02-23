package com.example.numfac.view.fragments

import com.example.numfac.entity.Date

interface DateView {
    fun showFac(date: Date)
    fun showProgress()
    fun hideProgress()
}
