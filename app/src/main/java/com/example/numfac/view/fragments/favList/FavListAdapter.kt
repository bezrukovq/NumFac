package com.example.numfac.view.fragments.favList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.numfac.R

class FavListAdapter(private var onItemClick: (Int) -> Unit) : RecyclerView.Adapter<FavViewHolder>() {

    lateinit var favList: ArrayList<Int>

    override fun getItemCount(): Int =
        favList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.number_item, parent, false)
        return FavViewHolder(v)
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        holder.bindViews(favList[position])
        holder.itemView.setOnClickListener { onItemClick(favList[position]) }    }
}
