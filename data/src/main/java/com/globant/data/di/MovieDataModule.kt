package com.globant.data.di

import com.globant.data.MovieService
import com.globant.data.dao.MovieDao
import com.globant.data.repository.MovieRepositoryImpl
import com.globant.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDataModule {

    @Provides
    @Singleton
    fun provideMovieInterface(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(movieService: MovieService, movieDao: MovieDao): MovieRepository =
        MovieRepositoryImpl(movieService = movieService, movieDao = movieDao)
}
