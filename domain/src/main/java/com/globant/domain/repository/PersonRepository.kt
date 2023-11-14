package com.globant.domain.repository

import com.globant.domain.model.Person

interface PersonRepository {
    suspend fun getPopularPeople(): List<Person>
}
