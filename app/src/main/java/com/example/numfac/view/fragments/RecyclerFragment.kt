package com.example.numfac.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.numfac.R
import com.example.numfac.model.NumFacModel
import com.example.numfac.presenter.DateListPresenter
import kotlinx.android.synthetic.main.fragment_recycler.*

@SuppressLint("Registered")
class RecyclerFragment : Fragment(), DateListView {

    private lateinit var recyclerAdapter: RecyclerAdapter
    private val dateListPresenter = DateListPresenter(NumFacModel(), this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_recycler, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerAdapter = RecyclerAdapter { onItemClick(it) }
        val manager = LinearLayoutManager(context)
        recycler_view.adapter = recyclerAdapter
        recycler_view.layoutManager = manager
        dateListPresenter.setDateList()
    }

    private fun onItemClick(int: Int) {
        activity?.let {
            it.supportFragmentManager
                .beginTransaction()
                .addToBackStack("JoJo")
                .replace(R.id.container, DateDetailsFragment.newInstance(int))
                .commit()
        }
    }

    override fun showDateList(dataList: List<Int>) {
        recyclerAdapter.list = dataList
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
