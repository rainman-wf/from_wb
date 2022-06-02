package ru.netology.timetotravel.repository

import androidx.lifecycle.LiveData
import ru.netology.timetotravel.dataobject.Data

interface FlightRepository {
    fun getAll(): LiveData<MutableList<Data>>
    fun like(position: Int)

}