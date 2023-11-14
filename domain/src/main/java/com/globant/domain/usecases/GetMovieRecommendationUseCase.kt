package com.globant.domain.usecases

import com.globant.domain.Resource
import com.globant.domain.repository.MovieRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieRecommendationUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    private var timeWindow: String = "day"
    operator fun invoke() = flow {
        try {
            val result = movieRepository.getMovieRecommendations(timeWindow)
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error("Connection Failed"))
        }
    }
}
