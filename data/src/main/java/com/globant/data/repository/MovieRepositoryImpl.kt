package com.globant.data.repository

import com.globant.data.MovieService
import com.globant.data.dao.MovieDao
import com.globant.data.entity.toDomain
import com.globant.data.response.toDomain
import com.globant.data.response.toEntity
import com.globant.domain.model.Movie
import com.globant.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val movieDao: MovieDao,
) : MovieRepository {

    override suspend fun getPopularMovies(): List<Movie> {
        runCatching {
            val movies = movieService.getPopularMovies()
            if (movies != null) {
                movieDao.insert(
                    movies.results.map {
                        it.toEntity().apply { type = MovieType.POPULAR.type }
                    },
                )
            }
        }
        return movieDao.getAllByType(MovieType.POPULAR.type).map { it.toDomain() }
    }

    override suspend fun getTopRatedMovies(): List<Movie> {
        runCatching {
            val movies = movieService.getTopRatedMovies()
            if (movies != null) {
                movieDao.insert(
                    movies.results.map {
                        it.toEntity().apply { type = MovieType.TOP_RATED.type }
                    },
                )
            }
        }
        return movieDao.getAllByType(MovieType.TOP_RATED.type).map { it.toDomain() }
    }

    override suspend fun getMovieRecommendations(timeWindow: String): List<Movie> {
        runCatching {
            val movies = movieService.getRecommendations(timeWindow = timeWindow)
            if (movies != null) {
                movieDao.insert(
                    movies.results.map {
                        it.toEntity().apply { type = MovieType.RECOMMENDATIONS.type }
                    },
                )
            }
        }
        return movieDao.getAllByType(MovieType.RECOMMENDATIONS.type).map { it.toDomain() }
    }
}

enum class MovieType(val type: String) {
    POPULAR("popular"),
    TOP_RATED("top_rated"),
    RECOMMENDATIONS("recommendations"),
}
