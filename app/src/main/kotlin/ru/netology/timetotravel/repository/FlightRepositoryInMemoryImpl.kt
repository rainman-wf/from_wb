package ru.netology.timetotravel.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import ru.netology.timetotravel.dataobject.Data
import ru.netology.timetotravel.retrofit.RetrofitInstance

class FlightRepositoryInMemoryImpl : FlightRepository {

    private val flights: MutableList<Data> = mutableListOf()

    private val data = MutableLiveData(flights)

    private val scope = CoroutineScope(Dispatchers.IO)

    init {
        scope.launch {
            val data: Deferred<List<Data>?> = async { loadData() }
            data.await()?.let {
                flights.addAll(it)
                this@FlightRepositoryInMemoryImpl.data.postValue(it.toMutableList())
            }
        }
    }

    private fun loadData(): List<Data>? {
        val response = RetrofitInstance.service.getData().execute()
        val data = response.body()?.data
        if (data.isNullOrEmpty()) return null
        return data
    }

    override fun getAll(): LiveData<MutableList<Data>> = data

    override fun like(position: Int) {
        val item = flights[position]
        flights[position] = item.copy(liked = !item.liked)
        data.value = flights
    }

    fun getByPosition(position: Int): Data {
        return flights[position]
    }
}