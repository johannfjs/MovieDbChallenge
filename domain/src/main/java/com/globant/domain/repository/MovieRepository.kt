package com.globant.domain.repository

import com.globant.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getTopRatedMovies(): List<Movie>
    suspend fun getMovieRecommendations(timeWindow: String): List<Movie>
}
