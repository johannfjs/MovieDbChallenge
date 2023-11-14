package com.globant.design.organisms

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.globant.design.model.MovieModel
import com.globant.design.molecules.Movie

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieList(
    movies: List<MovieModel>,
    onClick: ((MovieModel) -> Unit)? = null,
    onInfoClick: ((MovieModel) -> Unit)? = null,
) {
    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(items = movies, itemContent = {
                Movie(
                    movieModel = it,
                    onClick = onClick,
                    onInfoClick = onInfoClick,
                )
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun MovieListPreview() {
    val movies = listOf(
        MovieModel(
            id = 1,
            imageUrl = "https://image.tmdb.org/t/p/w500/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            voteAverage = 8.2,
            title = "The Suicide Squad",
            overview = "Text",
        ),
        MovieModel(
            id = 2,
            imageUrl = "https://image.tmdb.org/t/p/w500/bMadFzhjy9T7R8J48QGq1ngWNAK.jpg",
            voteAverage = 7.0,
            title = "The Godfather Part II",
            overview = "Text",
        ),
    )
    MovieList(movies = movies)
}
