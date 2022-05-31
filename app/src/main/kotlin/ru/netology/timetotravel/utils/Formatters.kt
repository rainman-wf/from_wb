package ru.netology.timetotravel.utils


import android.annotation.SuppressLint
import android.text.format.DateFormat


@SuppressLint("SimpleDateFormat")
fun formatDate(inputValue: String): String {
    val formatter = java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val date = formatter.parse(inputValue)
    return DateFormat.format("dd MMM yyyy", date).toString()
}
