package com.globant.feature.home.profile.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globant.design.R
import com.globant.design.atoms.Button
import com.globant.design.atoms.IconWithCircle
import com.globant.design.atoms.Text
import com.globant.design.model.ActionModel
import com.globant.design.model.MovieModel
import com.globant.design.molecules.Option
import com.globant.design.organisms.ActionList
import com.globant.design.organisms.MovieList
import com.globant.design.theme.DarkGray
import com.globant.design.theme.Gray
import com.globant.design.theme.LightGray
import com.globant.design.theme.White
import com.globant.design.theme.Yellow
import com.globant.feature.home.model.AccountModel
import com.globant.feature.home.profile.ProfileViewModel

@Composable
fun ProfileContent(viewModel: ProfileViewModel, account: AccountModel?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .background(LightGray),
    ) {
        HeaderProfile(account = account)
        Spacer(modifier = Modifier.height(16.dp))
        FollowingList()
        Spacer(modifier = Modifier.height(16.dp))
        RecentlyView(viewModel)
        Spacer(modifier = Modifier.height(16.dp))
        FavoritePeople()
        Spacer(modifier = Modifier.height(16.dp))
        MenuOptions()
    }
}

@Composable
fun HeaderProfile(account: AccountModel?) {
    val actions = listOf(
        ActionModel(
            title = "Calificaciones",
            text = "Calificaciones y obtener recomendaciones",
            number = 0,
        ),
        ActionModel(
            title = "Listas",
            text = "Agregar listas",
            number = 4,
        ),
        ActionModel(
            title = "Comentarios",
            text = "Aún no hay criticas",
            number = 0,
        ),
    )

    Column(modifier = Modifier.fillMaxWidth().background(White)) {
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            IconWithCircle(
                modifier = Modifier.size(48.dp),
                painterResource = R.drawable.ic_avatar,
            )
            Text(
                modifier = Modifier.weight(1f).padding(start = 16.dp)
                    .align(Alignment.CenterVertically),
                text = account?.username.orEmpty(),
                fontWeight = FontWeight.Bold,
                color = DarkGray,
            )
            Icon(
                modifier = Modifier.align(Alignment.CenterVertically).size(24.dp),
                painter = painterResource(id = R.drawable.ic_settings),
                contentDescription = "settings",
                tint = Yellow,
            )
        }
        Divider(modifier = Modifier.padding(horizontal = 16.dp), color = Gray, thickness = 1.dp)
        ActionList(modifier = Modifier.padding(16.dp), actions = actions)
    }
}

@Composable
fun MenuOptions() {
    val context = LocalContext.current

    Option(
        text = "Cines favoritos",
        onClick = { Toast.makeText(context, "Click Cines Favoritos", Toast.LENGTH_SHORT).show() },
    )
    Option(
        text = "Estaciones",
        onClick = { Toast.makeText(context, "Click Estaciones", Toast.LENGTH_SHORT).show() },
    )
    Option(
        text = "Notificaciones",
        onClick = { Toast.makeText(context, "Click Notificaciones", Toast.LENGTH_SHORT).show() },
    )
    Option(
        text = "Mejorar selecciones principales",
        onClick = {
            Toast.makeText(
                context,
                "Click Mejorar selecciones principales",
                Toast.LENGTH_SHORT,
            ).show()
        },
    )
}

@Composable
fun FavoritePeople() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(16.dp),
    ) {
        Text(
            text = "Personas favoritas",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        Text(
            text = "Añadir actores y directores favoritos y más para conocer las últimas novedades",
            fontSize = 12.sp,
        )
        Button(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            value = "Agregar personas favoritas",
            color = Yellow,
            textColor = DarkGray,
        )
    }
}

@Composable
fun RecentlyView(viewModel: ProfileViewModel) {
    // viewModel.getFavoriteMovies()
    // val favoriteMovies = viewModel.favoriteMovies.collectAsState()
    val favoriteMovies = emptyList<MovieModel>()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(16.dp),
    ) {
        Text(
            text = "Vistas recientemente",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        if (favoriteMovies.isEmpty()) {
            Text(
                text = "No has visitado ninguna página recientemente.",
                fontSize = 12.sp,
            )
        } else {
            FavoriteMovies(favoriteMovies)
        }
    }
}

@Composable
fun FavoriteMovies(favoriteMovies: List<MovieModel>) {
    Column(modifier = Modifier.fillMaxWidth().background(White)) {
        MovieList(
            movies = favoriteMovies,
        )
    }
}

@Composable
fun FollowingList() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(16.dp),
    ) {
        Text(
            text = "Lista de seguimiento",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        Text(
            text = "Crea una lista de seguimiento para no perderte ninguna película o serie de tv.",
            fontSize = 12.sp,
        )
        Button(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            value = "Empieza tu lista de seguimiento",
            color = Yellow,
            textColor = DarkGray,
        )
    }
}
