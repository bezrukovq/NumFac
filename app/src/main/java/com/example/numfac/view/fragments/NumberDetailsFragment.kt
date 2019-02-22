package com.example.numfac.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.numfac.R
import com.example.numfac.entity.Date
import kotlinx.android.synthetic.main.fragment_number_details.*

@SuppressLint("Registered")
class NumberDetailsFragment : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_number_details)
    }

    fun updateData(date: Date) {
        tv_date.text = date.date
        tv_month.text = date.month
        tv_fact.text = date.text
    }
}