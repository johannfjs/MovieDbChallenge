package com.globant.design.model

data class MovieModel(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val voteAverage: Double,
    val overview: String,
    val backdropPath: String? = null,
    val genres: List<GenreModel> = emptyList(),
    val originalTitle: String? = null,
    val tagline: String? = null,
)
