package com.globant.domain.model

data class Person(
    val name: String,
    val popularity: Double,
    val profilePath: String,
    val id: Int,
    val knownFor: List<KnownFor>,
)
