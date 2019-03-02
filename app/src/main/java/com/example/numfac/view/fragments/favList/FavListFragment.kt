package com.example.numfac.view.fragments.favList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.numfac.R
import com.example.numfac.model.NumFacModel
import com.example.numfac.presenter.FavListPresenter
import com.example.numfac.view.fragments.DateDetailsFragment
import kotlinx.android.synthetic.main.fragment_recycler.*

class FavListFragment : MvpAppCompatFragment(),FavListView {

    private lateinit var favListAdapter: FavListAdapter

    @InjectPresenter
    lateinit var favListPresenter: FavListPresenter

    @ProvidePresenter
    fun initPresenter(): FavListPresenter = FavListPresenter(NumFacModel())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_fav_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favListAdapter = FavListAdapter { onItemClick(it) }
        val manager = LinearLayoutManager(context)
        recycler_view.adapter = favListAdapter
        recycler_view.layoutManager = manager
        favListPresenter.setDateList()
    }


    private fun onItemClick(int: Int) =
        favListPresenter.openDate(int)

    override fun openDate(num: Int) {
        activity?.let {
            it.supportFragmentManager
                .beginTransaction()
                .addToBackStack("JoJo")
                .replace(R.id.container,
                    DateDetailsFragment.newInstance(num)
                )
                .commit()
        }
    }

    override fun showDateList(dataList: ArrayList<Int>) {
        favListAdapter.favList = dataList
    }

}
