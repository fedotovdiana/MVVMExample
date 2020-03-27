package com.itis.group11801.fedotova.mvvmexample.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun dateFormat(oldStringDate: String): String {
    val newDate: String
    val dateFormat = SimpleDateFormat("d MMM yyyy", Locale(getCountry()))
    newDate = try {
        val date: Date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(oldStringDate)
        dateFormat.format(date)
    } catch (e: ParseException) {
        e.printStackTrace()
        oldStringDate
    }
    return newDate
}

fun getCountry(): String {
    val locale: Locale = Locale.getDefault()
    val country: String = java.lang.String.valueOf(locale.country)
    return country.toLowerCase(Locale.ROOT)
}