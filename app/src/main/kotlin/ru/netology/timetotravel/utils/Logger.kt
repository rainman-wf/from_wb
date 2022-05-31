package ru.netology.timetotravel.utils

import timber.log.Timber

fun Any.log(msg: Any) {
    Timber.d(msg.toString())
}