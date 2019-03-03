package com.example.numfac.view.fragments.favList

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.numfac.entity.DateDB
import kotlinx.android.synthetic.main.number_item.view.*

class FavViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindViews(dateDB: DateDB) {
        itemView.tv_date.text = "${dateDB.text.split(" ")[0]} ${dateDB.text.split(" ")[1]}"
    }
}
