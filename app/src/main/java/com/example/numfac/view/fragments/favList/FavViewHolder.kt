package com.example.numfac.view.fragments.favList

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.number_item.view.*

class FavViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindViews(int: Int) {
        itemView.tv_date.text = int.toString()
    }
}
