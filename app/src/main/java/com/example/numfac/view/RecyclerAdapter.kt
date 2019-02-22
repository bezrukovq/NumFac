package com.example.numfac.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.numfac.R
import com.example.numfac.entity.Date

import kotlinx.android.synthetic.main.number_item.view.*

open class RecyclerAdapter(diffCallback: DiffUtil.ItemCallback<Date>, private var callbackItem: ItemCallback) : androidx.recyclerview.widget.ListAdapter<Date, RecyclerAdapter.MyViewHolder>(diffCallback){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.number_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindViews(getItem(position))
        holder.itemView.setOnClickListener { callbackItem.onItemClick(position) }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindViews(date: Date){
            itemView.tv_date_item.text = date.date
        }
    }
}
