package com.example.numfac.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.numfac.R
import kotlinx.android.synthetic.main.fragment_recycler.*
import java.util.*

@SuppressLint("Registered")
class RecyclerFragment : Fragment() {

    private lateinit var recyclerAdapter: RecyclerAdapter

    companion object {
        private const val COUNTER = 9
        fun newInstance(): RecyclerFragment {
            val args = Bundle()
            val fragment = RecyclerFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_recycler, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerAdapter = RecyclerAdapter { onItemClick(it) }
        val manager = LinearLayoutManager(context)
        recycler_view.adapter = recyclerAdapter
        recyclerAdapter.list = getDateList()
        recycler_view.layoutManager = manager
    }

    private fun onItemClick(int: Int) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.addToBackStack("JoJo")
            ?.replace(R.id.container, NumberDetailsFragment.newInstance(int))
            ?.commit()
    }

    private fun getDateList(): ArrayList<Int> {
        val list = ArrayList<Int>()
        val today = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        for (item: Int in today..today + COUNTER)
            list.add(item)
        return list
    }
}