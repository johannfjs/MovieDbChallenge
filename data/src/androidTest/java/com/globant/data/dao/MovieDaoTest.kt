package com.globant.data.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.globant.data.database.AppDatabase
import com.globant.data.entity.MovieEntity
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
@SmallTest
class MovieDaoTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var database: AppDatabase
    private lateinit var movieDao: MovieDao

    @Before
    fun setup() {
        hiltRule.inject()
        movieDao = database.movieDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertMovie() = runTest {
        val movie = mockMovie()
        movieDao.insert(listOf(movie))
        val allReminders = movieDao.getAllByType("top_rated")
        assertThat(allReminders).contains(movie)
    }

    private fun mockMovie() = MovieEntity(
        id = 1,
        title = "title",
        overview = "overview",
        posterPath = "posterPath",
        backdropPath = "backdropPath",
        voteAverage = 1.0,
        type = "top_rated",
    )
}
