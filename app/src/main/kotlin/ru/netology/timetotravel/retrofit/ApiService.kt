package ru.netology.timetotravel.retrofit

import retrofit2.Call
import retrofit2.http.*
import ru.netology.timetotravel.dataobject.Response

interface ApiService {

    @GET("cheap")
    fun getData(): Call<Response>

}