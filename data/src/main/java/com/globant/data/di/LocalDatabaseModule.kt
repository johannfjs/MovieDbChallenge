package com.globant.data.di

import android.content.Context
import androidx.room.Room
import com.globant.data.dao.AccountDao
import com.globant.data.dao.MovieDao
import com.globant.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = "movie-db",
        ).build()

    @Singleton
    @Provides
    fun provideAccountDao(database: AppDatabase): AccountDao = database.accountDao()

    @Singleton
    @Provides
    fun provideMovieDao(database: AppDatabase): MovieDao = database.movieDao()
}
