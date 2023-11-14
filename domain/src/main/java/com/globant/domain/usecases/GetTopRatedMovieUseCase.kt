package com.globant.domain.usecases

import com.globant.domain.Resource
import com.globant.domain.repository.MovieRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTopRatedMovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    operator fun invoke() = flow {
        try {
            val result = movieRepository.getTopRatedMovies()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error("Connection Failed"))
        }
    }
}
