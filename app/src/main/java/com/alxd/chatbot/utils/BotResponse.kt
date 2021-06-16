package com.alxd.chatbot.utils

import com.alxd.chatbot.utils.Constants.OPEN_GOOGLE
import com.alxd.chatbot.utils.Constants.OPEN_SEARCH
import java.lang.Exception
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message : String) : String{
        val random = (0..2).random()
        val message = _message.toLowerCase()

        return when{
            //Hello
            message.contains("hola") || message.contains("que onda")-> {
                when (random) {
                    0 -> "Hola!"
                    1 -> "Que onda prix"
                    2 -> "Que hay, te puedo ayudar?"
                    else -> "error" }
            }
            //Aritmetica basica , Suma, resta, multiplicacion y division
            message.contains("resolver") ->{
                val equation:String? = message.substringAfterLast("resolver")
                return try{
                    val aswer = SolveMath.solveMath(equation ?: "0")
                    "$aswer"
                }catch (e:Exception){
                    "Lo siento, no he podido resolver eso :("
                }
            }
            //Que hora es?
            message.contains("hora") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("HH:mm:ss")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }
            //Abrir Google
            message.contains("abrir") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Buscar en internet
            message.contains("buscar")-> {
                OPEN_SEARCH
            }

            //Cuando no entiendo el mensaje...
            else -> {
                when (random) {
                    0 -> "No te entiendo..."
                    1 -> "Trata consultando algo diferente :/"
                    2 -> "Ohh que mal, no he podido entenderte"
                    else -> "error"
                }
            }
        }
    }
}