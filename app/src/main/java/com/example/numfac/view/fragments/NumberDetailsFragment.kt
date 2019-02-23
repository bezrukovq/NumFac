package com.example.numfac.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.numfac.entity.Date
import kotlinx.android.synthetic.main.fragment_number_details.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.numfac.R


@SuppressLint("Registered")
class NumberDetailsFragment : Fragment() {

    private var number = arguments?.get("number")// этим полем пиннаем presenter'a

    companion object {
        fun newInstance(int: Int): NumberDetailsFragment {
            val args = Bundle()
            args.putInt("number", int)
            val fragment = NumberDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_number_details, container, false)
    }

    fun updateData(date: Date) {
        tv_date.text = date.date
        tv_month.text = date.month
        tv_fact.text = date.text
    }
}