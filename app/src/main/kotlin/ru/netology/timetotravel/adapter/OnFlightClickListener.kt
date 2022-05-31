package ru.netology.timetotravel.adapter

interface OnFlightClickListener {
    fun onLike(position: Int)
    fun onDetails(position: Int)
}