package com.globant.feature.home.movie

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.globant.feature.home.movie.ui.MovieContent

@Composable
fun MovieScreen() {
    val viewModel = hiltViewModel<MovieViewModel>()

    MovieContent(viewModel = viewModel)
}
