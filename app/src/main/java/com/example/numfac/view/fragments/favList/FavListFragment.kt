package com.example.numfac.view.fragments.favList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.numfac.R
import com.example.numfac.di.component.DaggerDateComponent
import com.example.numfac.di.module.DateModule
import com.example.numfac.entity.DateDB
import com.example.numfac.presenter.FavListPresenter
import com.example.numfac.view.MainActivity
import kotlinx.android.synthetic.main.fragment_recycler.*
import javax.inject.Inject

class FavListFragment : MvpAppCompatFragment(), FavListView {
    //hz kak v dagger
    private var favListAdapter = FavListAdapter { onItemClick(it) }

    @Inject
    @InjectPresenter
    lateinit var favListPresenter: FavListPresenter

    @ProvidePresenter
    fun initPresenter() = favListPresenter

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
        inflater.inflate(R.layout.fragment_fav_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val manager = LinearLayoutManager(context)
        recycler_view.adapter = favListAdapter
        recycler_view.layoutManager = manager
        favListPresenter.setDateList()
    }

    private fun onItemClick(dateDB: DateDB) =
        favListPresenter.openDate(dateDB)


    override fun showDateList(dataList: List<DateDB>) {
        favListAdapter.favList = dataList
        favListAdapter.notifyDataSetChanged()
        if (favListAdapter.favList.size == 0)
            Toast.makeText(this.context, "You haven't liked anything yet", Toast.LENGTH_LONG).show()
    }
}
