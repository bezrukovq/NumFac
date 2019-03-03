package com.example.numfac.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.numfac.R
import com.example.numfac.entity.Date
import com.example.numfac.entity.DateDB
import com.example.numfac.model.NumFacModel
import com.example.numfac.presenter.DateDetailPresenter
import kotlinx.android.synthetic.main.fragment_number_details.*

class DateDetailsFragment : MvpAppCompatFragment(), DateView {

    private var liked = false

    @InjectPresenter
    lateinit var dateDetailPresenter: DateDetailPresenter

    @ProvidePresenter
    fun initPresenter(): DateDetailPresenter = DateDetailPresenter(NumFacModel)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_number_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            img_like.setOnClickListener { likePressed() }
            val cached = arguments?.getBoolean(ARG_CACHED)
            if (cached != null && cached)
                showCached(arguments?.getString(ARG_TEXT).toString())
            else
                dateDetailPresenter.getDateInfo(arguments?.getInt("number"))
        }
    }

    private fun likePressed() {
        if (!liked)
            like()
        else
            unlike()
    }

    private fun unlike() {
        liked = false
        img_like.setImageResource(R.drawable.ic_favorite)
        dateDetailPresenter.deleteFromFav(DateDB(tv_fact.text as String))
    }

    private fun like() {
        liked = true
        img_like.setImageResource(R.drawable.ic_favorite_selected)
        Toast.makeText(this.context, "LIKED", Toast.LENGTH_LONG).show()
        dateDetailPresenter.saveToFav(DateDB(tv_fact.text as String))
    }

    fun showCached(text: String) {
        tv_fact.text = text
        liked = true
        img_like.setImageResource(R.drawable.ic_favorite_selected)
        img_like.visibility = View.VISIBLE
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
        img_like.visibility = View.VISIBLE
    }

    override fun showError(string: String) {
        tv_fact?.text = string
    }

    companion object {
        const val ARG_SOME_NAME = "number"
        const val ARG_TEXT = "text"
        const val ARG_CACHED = "cached"
        fun newInstance(int: Int): DateDetailsFragment {
            val args = Bundle()
            args.putInt(ARG_SOME_NAME, int)
            args.putBoolean(ARG_CACHED, false)
            val fragment = DateDetailsFragment()
            fragment.arguments = args
            return fragment
        }

        fun newInstance(dateDB: DateDB): DateDetailsFragment {
            val args = Bundle()
            args.putString(ARG_TEXT, dateDB.text)
            args.putBoolean(ARG_CACHED, true)
            val fragment = DateDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
