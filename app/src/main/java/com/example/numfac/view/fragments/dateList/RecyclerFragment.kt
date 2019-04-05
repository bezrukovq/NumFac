package com.example.numfac.view.fragments.dateList

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.numfac.R
import com.example.numfac.di.component.DaggerDateComponent
import com.example.numfac.di.module.DateModule
import com.example.numfac.model.PaginationPreferences
import com.example.numfac.presenter.DateListPresenter
import com.example.numfac.view.MainActivity
import com.example.numfac.view.dialogs.DownloadSizeDialog
import kotlinx.android.synthetic.main.fragment_recycler.*
import javax.inject.Inject

@SuppressLint("Registered")
class RecyclerFragment : MvpAppCompatFragment(), DateListView {
    //hz kak v dagger
    var recyclerAdapter = RecyclerAdapter { onItemClick(it) }

    @Inject
    @InjectPresenter
    lateinit var dateListPresenter: DateListPresenter

    @ProvidePresenter
    fun initPresenter() = dateListPresenter

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
        inflater.inflate(R.layout.fragment_recycler, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PaginationPreferences.init(context)
        val manager = LinearLayoutManager(context)
        recycler_view.adapter = recyclerAdapter
        recycler_view.addOnScrollListener(recyclerViewOnScrollListener)
        recycler_view.layoutManager = manager
        dateListPresenter.setDateList()
        recycler_fab.setOnClickListener {
            val dlg1 = DownloadSizeDialog()
            dlg1.show(fragmentManager, "dlg1")
        }
    }

    private fun onItemClick(int: Int) =
        dateListPresenter.openDate(int)

    override fun showDateList(dataList: ArrayList<Int>) {
        recyclerAdapter.list = dataList
    }

    override fun expandDateList(dataList: ArrayList<Int>) {
        recyclerAdapter.addAll(dataList)
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (!recyclerView.canScrollVertically(1)) {
                dateListPresenter.expendDateList(PaginationPreferences.paginationSize)
            }
        }
    }

    companion object {
        fun newInstance(): RecyclerFragment {
            val args = Bundle()
            val fragment = RecyclerFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
