package com.ironbird.datatypes

import java.util.Date

data class Foo(
    val name: String,
    val datOfBirth: java.sql.Date,
    val bar: Bar,
)
