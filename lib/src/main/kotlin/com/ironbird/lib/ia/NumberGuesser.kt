package com.ironbird.lib.ia

class NumberGuesser {
    fun guessGreater(seed: Int): Int {
        return seed + (1..8).random()
    }
}