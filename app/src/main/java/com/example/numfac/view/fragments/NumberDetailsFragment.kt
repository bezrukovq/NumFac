package com.example.numfac.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.numfac.entity.Date
import kotlinx.android.synthetic.main.fragment_number_details.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.numfac.R
import com.example.numfac.model.NumFacModel
import com.example.numfac.presenter.Presenter

class NumberDetailsFragment : Fragment(), com.example.numfac.view.View {

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
        val view= inflater.inflate(R.layout.fragment_number_details, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Presenter(NumFacModel(), this).getDateInfo(arguments?.getInt("number"))
    }

    override fun showFac(date: Date) {
        tv_date.text = date.date
        tv_month.text = date.month
        tv_fact.text = date.text    }

    override fun showProgress() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_bar.visibility = View.GONE
    }

}
