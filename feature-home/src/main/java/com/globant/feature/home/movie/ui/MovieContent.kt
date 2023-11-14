package com.globant.feature.home.movie.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.globant.design.atoms.Text
import com.globant.design.organisms.MovieList
import com.globant.design.theme.LightGray
import com.globant.design.theme.White
import com.globant.feature.home.movie.MovieViewModel

@Composable
fun MovieContent(viewModel: MovieViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .background(LightGray),
    ) {
        PopularMovies(viewModel = viewModel)
        Spacer(modifier = Modifier.height(16.dp))
        TopRatedMovies(viewModel = viewModel)
        Spacer(modifier = Modifier.height(16.dp))
        RecommendedMovies(viewModel = viewModel)
    }
}

@Composable
fun RecommendedMovies(viewModel: MovieViewModel) {
    val context = LocalContext.current
    val recommendedMovies = viewModel.recommendedMovies.collectAsState()

    Column(modifier = Modifier.fillMaxWidth().background(White).padding(16.dp)) {
        Text(
            text = "Recommended",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        MovieList(
            movies = recommendedMovies.value,
            onClick = {
                Toast.makeText(context, "Title: ${it.title}", Toast.LENGTH_SHORT).show()
            },
        )
    }
}

@Composable
fun TopRatedMovies(viewModel: MovieViewModel) {
    val context = LocalContext.current
    val topRatedMovies = viewModel.topRatedMovies.collectAsState()

    Column(modifier = Modifier.fillMaxWidth().background(White).padding(16.dp)) {
        Text(
            text = "Top Rated",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        MovieList(
            movies = topRatedMovies.value,
            onInfoClick = {
                Toast.makeText(context, "Info: ${it.title}", Toast.LENGTH_SHORT).show()
            },
        )
    }
}

@Composable
fun PopularMovies(viewModel: MovieViewModel) {
    val context = LocalContext.current
    val popularMovies = viewModel.popularMovies.collectAsState()

    Column(modifier = Modifier.fillMaxWidth().background(White).padding(16.dp)) {
        Text(
            text = "Populars",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        MovieList(
            movies = popularMovies.value,
            onInfoClick = {
                Toast.makeText(context, "Info: ${it.title}", Toast.LENGTH_SHORT).show()
            },
        )
    }
}
