package com.example.numfac.view

import androidx.recyclerview.widget.DiffUtil
import com.example.numfac.entity.Date

class DateDiffCallBack : DiffUtil.ItemCallback<Date>(){
    override fun areItemsTheSame(old: Date, aNew: Date): Boolean = old.date.equals(aNew.date) && old.month.equals(aNew.month)

    override fun areContentsTheSame(old: Date, aNew: Date): Boolean = old.text.equals(aNew.text)
}