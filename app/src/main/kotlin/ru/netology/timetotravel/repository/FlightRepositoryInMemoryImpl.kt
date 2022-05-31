package ru.netology.timetotravel.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.timetotravel.dataobject.Data
import ru.netology.timetotravel.retrofit.RetrofitInstance

class FlightRepositoryInMemoryImpl : FlightRepository {

    private val flights: MutableList<Data> = mutableListOf()

    private val data = MutableLiveData(flights)

    init {
        Thread {
            val response = RetrofitInstance.service.getData().execute()
            val data = response.body()?.data ?: return@Thread
            flights.addAll(data.toList())
            this.data.postValue(data.toMutableList())
        }.start()
    }

    override fun getAll(): LiveData<MutableList<Data>> = data

    override fun like(position: Int) {
        val item = flights[position]
        flights[position] = item.copy(liked = !item.liked)
        data.value = flights
    }
}