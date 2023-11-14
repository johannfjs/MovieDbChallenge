package com.globant.feature.home.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globant.design.model.GenreModel
import com.globant.design.model.MovieModel
import com.globant.domain.model.Genre
import com.globant.domain.model.Movie
import com.globant.domain.usecases.GetMovieRecommendationUseCase
import com.globant.domain.usecases.GetPopularMovieUseCase
import com.globant.domain.usecases.GetTopRatedMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovieRecommendationUseCase: GetMovieRecommendationUseCase,
    private val getPopularMovieUseCase: GetPopularMovieUseCase,
    private val getTopRatedMovieUseCase: GetTopRatedMovieUseCase,
) : ViewModel() {

    private val _popularMovies =
        MutableStateFlow<List<MovieModel>>(emptyList())
    var popularMovies: StateFlow<List<MovieModel>> = _popularMovies

    private val _topRatedMovies =
        MutableStateFlow<List<MovieModel>>(emptyList())
    var topRatedMovies: StateFlow<List<MovieModel>> = _topRatedMovies

    private val _recommendedMovies =
        MutableStateFlow<List<MovieModel>>(emptyList())
    var recommendedMovies: StateFlow<List<MovieModel>> = _recommendedMovies

    init {
        getPopularMovies()
        getTopRatedMovies()
        getRecommendedMovies()
    }

    fun getPopularMovies() {
        viewModelScope.launch {
            getPopularMovieUseCase().onStart {
            }.catch {
            }.collect {
                _popularMovies.value = it.data.orEmpty().toListModel()
            }
        }
    }

    fun getTopRatedMovies() {
        viewModelScope.launch {
            getTopRatedMovieUseCase().onStart {
            }.catch {
            }.collect {
                _topRatedMovies.value = it.data.orEmpty().toListModel()
            }
        }
    }

    fun getRecommendedMovies() {
        viewModelScope.launch {
            getMovieRecommendationUseCase().onStart {
            }.catch {
            }.collect {
                _recommendedMovies.value = it.data.orEmpty().toListModel()
            }
        }
    }
}

fun Movie.toModel() =
    MovieModel(
        id = id,
        title = title,
        imageUrl = "https://image.tmdb.org/t/p/w500/$posterPath",
        voteAverage = voteAverage,
        overview = overview,
        backdropPath = "https://image.tmdb.org/t/p/w500/$backdropPath",
        genres = genres.toListModel(),
        originalTitle = originalTitle,
        tagline = tagline,
    )

fun MovieModel.toDomain() =
    Movie(
        id = id,
        title = title,
        voteAverage = voteAverage,
        overview = overview,
        posterPath = imageUrl,
    )

@JvmName("toMovieListModel")
fun List<Movie>.toListModel() = map { it.toModel() }

fun Genre.toModel() =
    GenreModel(id = id, name = name)

@JvmName("toGenreListModel")
fun List<Genre>.toListModel() = map { it.toModel() }
