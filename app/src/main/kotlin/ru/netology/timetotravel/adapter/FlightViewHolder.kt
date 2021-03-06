package ru.netology.timetotravel.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import ru.netology.timetotravel.R
import ru.netology.timetotravel.databinding.FlightItemCardBinding
import ru.netology.timetotravel.dataobject.Data
import ru.netology.timetotravel.utils.*

class FlightViewHolder(
    private val binding: FlightItemCardBinding,
    private val onFlightClickListener: OnFlightClickListener
) : RecyclerView.ViewHolder(binding.root){

    @SuppressLint("SetTextI18n")
    fun bind(flight: Data) {

        binding.apply {
            startDate.text = formatDate(flight.startDate)
            endDate.text = formatDate(flight.endDate)
            price.text = "${flight.price} ${binding.root.context.getText(R.string.currency)}"
            header.text = "${flight.startCity} — ${flight.endCity}"

            like.isChecked = flight.liked

            like.setOnClickListener { onFlightClickListener.onLike(bindingAdapterPosition) }
            details.setOnClickListener {onFlightClickListener.onDetails(bindingAdapterPosition)}

        }
    }
}