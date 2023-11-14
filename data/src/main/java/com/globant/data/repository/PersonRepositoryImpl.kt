package com.globant.data.repository

import com.globant.data.PersonService
import com.globant.data.response.toDomain
import com.globant.domain.model.Person
import com.globant.domain.repository.PersonRepository
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(private val personService: PersonService) :
    PersonRepository {
    override suspend fun getPopularPeople(): List<Person> {
        return personService.getPopularPeople().results.map { it.toDomain() }
    }
}
