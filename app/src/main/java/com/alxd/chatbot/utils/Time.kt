package com.alxd.chatbot.utils

import android.annotation.SuppressLint
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object Time {

    @SuppressLint("SimpleDateFormat")
    fun timeStamp() : String{
        val timeStamp = Timestamp(System.currentTimeMillis())
        val sdf = SimpleDateFormat("HH:mm")

        return sdf.format(Date(timeStamp.time))
    }
}