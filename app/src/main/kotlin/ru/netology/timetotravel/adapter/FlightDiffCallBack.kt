package ru.netology.timetotravel.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.netology.timetotravel.dataobject.Data

class FlightDiffCallBack : DiffUtil.ItemCallback<Data>() {

    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.searchToken == newItem.searchToken
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}