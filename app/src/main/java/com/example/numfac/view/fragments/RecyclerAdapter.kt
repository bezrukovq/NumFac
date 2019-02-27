package com.example.numfac.view.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.numfac.R

class RecyclerAdapter(private var onItemClick: (Int) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    lateinit var list: ArrayList<Int>
    override fun getItemCount() = list.size

    fun addAll(values: List<Int>) {
        //var oldlist: ArrayList<Int> = list
        for (value in values) {
            list.add(value)
            notifyItemInserted(list.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.number_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(list[position])
        holder.itemView.setOnClickListener { onItemClick(list[position]) }
    }
}
