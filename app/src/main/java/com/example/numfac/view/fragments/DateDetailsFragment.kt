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
import com.example.numfac.di.component.DaggerDateComponent
import com.example.numfac.di.module.DateModule
import com.example.numfac.entity.Date
import com.example.numfac.entity.DateDB
import com.example.numfac.presenter.DateDetailPresenter
import com.example.numfac.view.MainActivity
import kotlinx.android.synthetic.main.fragment_number_details.*
import ru.terrakok.cicerone.Screen
import javax.inject.Inject

class DateDetailsFragment : MvpAppCompatFragment(), DateView {

    @Inject
    @InjectPresenter
    lateinit var dateDetailPresenter: DateDetailPresenter

    @ProvidePresenter
    fun initPresenter() = dateDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerDateComponent
            .builder()
            .appComponent(MainActivity.appComponent)
            .dateModule(DateModule())
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_number_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            img_like.setOnClickListener { dateDetailPresenter.likePressed(DateDB(tv_fact.text.toString())) }
            val cached = arguments?.getBoolean(ARG_CACHED)
            val textCached = arguments?.getString(ARG_TEXT).toString()
            val numRequest = arguments?.getInt("number")
            dateDetailPresenter.checkCached(cached, textCached, numRequest)
        }
    }

    override fun unlike() =
        img_like.setImageResource(R.drawable.ic_favorite)

    override fun like() {
        img_like.setImageResource(R.drawable.ic_favorite_selected)
        Toast.makeText(this.context, "LIKED", Toast.LENGTH_LONG).show()
    }

    override fun showCached(text: String) {
        tv_fact.text = text
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

    override fun showError(string: String?) {
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
