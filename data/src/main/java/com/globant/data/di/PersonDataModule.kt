package com.globant.data.di

import com.globant.data.PersonService
import com.globant.data.repository.PersonRepositoryImpl
import com.globant.domain.repository.PersonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersonDataModule {

    @Provides
    @Singleton
    fun providePersonInterface(retrofit: Retrofit): PersonService {
        return retrofit.create(PersonService::class.java)
    }

    @Provides
    @Singleton
    fun providePersonRepository(personService: PersonService): PersonRepository =
        PersonRepositoryImpl(personService = personService)
}
