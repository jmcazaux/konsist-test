package com.ironbird.app

import com.ironbird.lib.ia.NumberGuesser
import java.lang.Thread.sleep


fun main() {
    val number = (1..50).random()
    println("*".repeat(80))
    println("IronBird AI will guess a number above $number...")
    var teaser = "."
    for (i in 1..10) {
        println(teaser)
        teaser += "."
        sleep(100)
    }
    val guess = NumberGuesser().guessGreater(number)
    println("\nIronBird AI guessed $guess!\nIt is above $number, isn't it?")
    println("*".repeat(80))
}
