package ru.netology.timetotravel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.netology.timetotravel.dataobject.Data
import ru.netology.timetotravel.repository.FlightRepositoryInMemoryImpl

class FlightViewModel: ViewModel() {

    private val repository = FlightRepositoryInMemoryImpl()

    val item = MutableLiveData<Data?>(null)

    val data = repository.getAll()

    fun onLikeClicked(position: Int) {
        repository.like(position)
        item.value = repository.getByPosition(position)
    }

    fun onDetailsClicked(position: Int) {
        item.value = repository.getByPosition(position)
    }
}