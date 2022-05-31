package ru.netology.timetotravel.dataobject

data class Data(
    val endCity: String,
    val endCityCode: String,
    val endDate: String,
    val price: Int,
    val searchToken: String,
    val startCity: String,
    val startCityCode: String,
    val startDate: String,
    val liked: Boolean = false
)