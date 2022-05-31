package ru.netology.timetotravel.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.netology.timetotravel.dataobject.Data
import ru.netology.timetotravel.utils.log

class FlightDiffCallBack : DiffUtil.ItemCallback<Data>() {

    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        val result = oldItem.searchToken == newItem.searchToken
        log("in item $result")
        return result
    }


    override fun areContentsTheSame(oldItem: Data, newItem: Data) :Boolean {
        val result = oldItem == newItem
        log("in contents $result")
        return result
    }
}