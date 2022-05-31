package ru.netology.timetotravel.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.timetotravel.repository.FlightRepositoryInMemoryImpl

class FlightViewModel: ViewModel() {

    private val repository = FlightRepositoryInMemoryImpl()

    val data = repository.getAll()

    fun onLikeClicked(position: Int) = repository.like(position)
}