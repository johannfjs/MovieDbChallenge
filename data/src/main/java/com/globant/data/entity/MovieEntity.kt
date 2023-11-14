package com.globant.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.globant.domain.model.Movie

@Entity
data class MovieEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val posterPath: String,
    val voteAverage: Double,
    val overview: String,
    val backdropPath: String? = null,
    val originalTitle: String? = null,
    val tagline: String? = null,
    val favorite: Boolean = false,
    var type: String? = null,
)

fun MovieEntity.toDomain() =
    Movie(
        id = id,
        title = title,
        posterPath = posterPath,
        voteAverage = voteAverage,
        overview = overview,
        backdropPath = backdropPath,
        originalTitle = originalTitle,
        tagline = tagline,
        favorite = favorite,
    )
