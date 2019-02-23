package com.example.numfac.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.numfac.R

@SuppressLint("Registered")
class RecyclerFragment : Fragment() {

    private lateinit var recyclerAdapter: RecyclerAdapter

    companion object {
        fun newInstance(): RecyclerFragment {
            val args = Bundle()
            val fragment = RecyclerFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_recycler, container, false)
        recyclerAdapter = RecyclerAdapter {onItemClick(it)}
        val manager = LinearLayoutManager(context)
        val rv = v.findViewById<RecyclerView>(R.id.recycler_view)
        rv.adapter = recyclerAdapter
        recyclerAdapter.list = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        rv.layoutManager = manager
        return v
    }

    private fun onItemClick(int: Int) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.addToBackStack("JoJo")
            ?.replace(R.id.container, NumberDetailsFragment.newInstance(int))
            ?.commit()

    }
}
