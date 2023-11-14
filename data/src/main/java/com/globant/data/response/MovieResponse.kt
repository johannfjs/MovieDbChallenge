package com.globant.data.response

import com.globant.data.entity.MovieEntity
import com.globant.domain.model.Movie
import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    val page: Int,
    val results: List<T>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int,
)

data class MovieResponse(
    val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    val id: Int,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int,
)

fun MovieResponse.toDomain(): Movie =
    Movie(
        id = id,
        title = title,
        posterPath = posterPath,
        voteAverage = voteAverage,
        overview = overview,
    )

fun MovieResponse.toEntity(): MovieEntity =
    MovieEntity(
        id = id,
        title = title,
        posterPath = posterPath,
        voteAverage = voteAverage,
        overview = overview,
    )
