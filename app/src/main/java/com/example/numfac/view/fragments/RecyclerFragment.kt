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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_recycler, container, false)
    

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerAdapter = RecyclerAdapter {onItemClick(it)}
        val manager = LinearLayoutManager(context)
        recycler_view.adapter = recyclerAdapter
        recyclerAdapter.list = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        recycler_view.layoutManager = manager
    }

    private fun onItemClick(int: Int) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.addToBackStack("JoJo")
            ?.replace(R.id.container, NumberDetailsFragment.newInstance(int))
            ?.commit()
    }
}
