package com.globant.domain.usecases

import com.globant.domain.Resource
import com.globant.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPopularMovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    operator fun invoke() = flow {
        try {
            val result = movieRepository.getPopularMovies()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error("Connection Failed"))
        }
    }.flowOn(Dispatchers.Default)
}
