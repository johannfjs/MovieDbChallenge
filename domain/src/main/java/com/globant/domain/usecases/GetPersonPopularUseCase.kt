package com.globant.domain.usecases

import com.globant.domain.Resource
import com.globant.domain.repository.PersonRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPersonPopularUseCase @Inject constructor(private val personRepository: PersonRepository) {
    operator fun invoke() = flow {
        try {
            val result = personRepository.getPopularPeople()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error("Connection Failed"))
        }
    }
}
