package com.orange.noteappbasic.util

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(string:String) :String{
    val date = Date(string).time
    val dateTime = Date(date)
    val format = SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault())
    return format.format(dateTime)
}