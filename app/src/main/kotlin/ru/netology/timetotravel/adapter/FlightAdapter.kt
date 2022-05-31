package ru.netology.timetotravel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.netology.timetotravel.databinding.FlightItemCardBinding
import ru.netology.timetotravel.dataobject.Data

class FlightAdapter(private val onFlightClickListener: OnFlightClickListener) :
    ListAdapter<Data, FlightViewHolder>(FlightDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FlightItemCardBinding.inflate(inflater, parent, false)
        return FlightViewHolder(binding, onFlightClickListener)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}