package com.example.numfac.view

import com.example.numfac.entity.Date

interface View {
    fun showFac(date: Date)

    fun showProgress()
    fun hideProgress()
}
