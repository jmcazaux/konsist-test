package com.ironbird.datatypes

data class Bar(
    val size: Int,
    val color: Color,

) {
    enum class Color {
        RED,
        GREEN,
        BLUE,
    }
}
