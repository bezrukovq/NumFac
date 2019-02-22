package com.example.numfac.view.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.numfac.R

import kotlinx.android.synthetic.main.number_item.view.*

class RecyclerAdapter(private var onItemClick: (Int) -> Unit) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    lateinit var list: List<Int>
    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.number_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(list[position])
        holder.itemView.setOnClickListener { onItemClick(position) }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViews(int: Int) {
            itemView.tv_date_item.text = Int.toString()
        }
    }
}
