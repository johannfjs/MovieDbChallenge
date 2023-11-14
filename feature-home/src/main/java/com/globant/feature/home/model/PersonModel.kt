package com.globant.feature.home.model

import com.globant.domain.model.KnownFor
import com.globant.domain.model.Person

data class PersonModel(
    val name: String,
    val popularity: Double,
    val profilePath: String,
    val id: Int,
    val knownFor: List<KnownForModel>,
)

data class KnownForModel(
    val title: String?,
    val overview: String,
    val posterPath: String,
    val releaseDate: String?,
    val popularity: Double,
)

fun Person.toModel(): PersonModel =
    PersonModel(
        name = name,
        popularity = popularity,
        profilePath = "https://image.tmdb.org/t/p/w500/$profilePath",
        id = id,
        knownFor = knownFor.map { it.toModel() },
    )

fun KnownFor.toModel(): KnownForModel =
    KnownForModel(
        title = title,
        overview = overview,
        posterPath = "https://image.tmdb.org/t/p/w500/$posterPath",
        releaseDate = releaseDate,
        popularity = popularity,
    )
