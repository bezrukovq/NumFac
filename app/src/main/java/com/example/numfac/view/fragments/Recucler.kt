package com.example.numfac.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.numfac.view.DateDiffCallBack
import com.example.numfac.view.ItemCallback
import com.example.numfac.view.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*

@SuppressLint("Registered")
class RecyclerFragment : FragmentActivity(), ItemCallback {


    private lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        recyclerAdapter = RecyclerAdapter(DateDiffCallBack(), this)
        val manager = LinearLayoutManager(this)
        recycler_view.adapter = recyclerAdapter
        recycler_view.layoutManager = manager
    }

    override fun onItemClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}