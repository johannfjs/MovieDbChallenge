package com.globant.design.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.globant.design.R
import com.globant.design.atoms.Text
import com.globant.design.model.MovieModel
import com.globant.design.theme.White

@Composable
fun Movie(
    movieModel: MovieModel,
    onClick: ((MovieModel) -> Unit)? = null,
    onBookmarkClick: ((MovieModel) -> Unit)? = null,
    onInfoClick: ((MovieModel) -> Unit)? = null,
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.clickable(onClick != null) { onClick?.invoke(movieModel) },
    ) {
        Column(modifier = Modifier.background(White).width(130.dp).height(260.dp)) {
            Box {
                AsyncImage(
                    model = movieModel.imageUrl,
                    contentDescription = "Movie Image",
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_bookmark_favorite),
                    contentDescription = "Bookmark Favorite",
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp).size(24.dp)
                        .clickable(onBookmarkClick != null) { onBookmarkClick?.invoke(movieModel) },
                )
            }
            Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = "Star",
                        modifier = Modifier.size(12.dp).align(CenterVertically),
                        tint = Color.Unspecified,
                    )
                    Text(
                        text = movieModel.voteAverage.toString(),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 4.dp),
                    )
                }
                Text(text = movieModel.title, fontSize = 12.sp, maxLines = 1)
                Icon(
                    painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = "Info",
                    modifier = Modifier.align(End).size(16.dp)
                        .clickable(onInfoClick != null) { onInfoClick?.invoke(movieModel) },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun MoviePreview() {
    Movie(
        movieModel = MovieModel(
            id = 1,
            imageUrl = "https://image.tmdb.org/t/p/w500/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            voteAverage = 8.5,
            title = "The Suicide Squad",
            overview = "texto",
        ),
    )
}
