package com.globant.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val posterPath: String,
    val voteAverage: Double,
    val overview: String,
    val backdropPath: String? = null,
    val genres: List<Genre> = emptyList(),
    val originalTitle: String? = null,
    val tagline: String? = null,
    val favorite: Boolean = false,
)
