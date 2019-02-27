package com.example.numfac.view.fragments

import android.os.Bundle
import com.example.numfac.entity.Date
import kotlinx.android.synthetic.main.fragment_number_details.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.numfac.R
import com.example.numfac.model.NumFacModel
import com.example.numfac.presenter.DateDetailPresenter

class DateDetailsFragment : MvpAppCompatFragment(), DateView {

    @InjectPresenter
    lateinit var dateDetailPresenter: DateDetailPresenter // DateDetailPresenter(NumFacModel(), this)

    @ProvidePresenter
    fun initPresenter(): DateDetailPresenter = DateDetailPresenter(NumFacModel(), this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_number_details, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
        dateDetailPresenter.getDateInfo(arguments?.getInt("number"))
    }

    override fun showProgress() {
        progress_bar?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_bar?.visibility = View.GONE
    }

    override fun showDate(date: Date) {
        tv_date?.text = date.date
    }

    override fun showMonth(date: Date) {
        tv_month?.text = date.month
    }

    override fun showFact(date: Date) {
        tv_fact?.text = date.text
    }

    override fun showError(string: String) {
        tv_fact?.text = string
    }

    companion object {
        const val ARG_SOME_NAME = "number"
        fun newInstance(int: Int): DateDetailsFragment {
            val args = Bundle()
            args.putInt(ARG_SOME_NAME, int)
            val fragment = DateDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
