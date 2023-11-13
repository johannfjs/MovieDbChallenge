package com.globant.moviedbchallenge.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.globant.design.theme.White
import com.globant.design.theme.Yellow
import com.globant.feature.home.gallery.GalleryScreen
import com.globant.feature.home.location.LocationScreen
import com.globant.feature.home.movie.MovieScreen
import com.globant.feature.home.profile.ProfileScreen
import com.globant.navigation.NavigationManager
import com.globant.navigation.directions.GalleryNavigation
import com.globant.navigation.directions.LocationNavigation
import com.globant.navigation.directions.MovieNavigation
import com.globant.navigation.directions.PopBackStack
import com.globant.navigation.directions.ProfileNavigation
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun MovieNavHost(navController: NavHostController) {
    NavHost(
        navController,
        startDestination = ProfileNavigation.destination,
    ) {
        composable(ProfileNavigation.route) { ProfileScreen() }
        composable(MovieNavigation.route) { MovieScreen() }
        composable(LocationNavigation.route) { LocationScreen() }
        composable(GalleryNavigation.route) { GalleryScreen() }
    }
}

@Composable
fun HandleNavigationCommands(
    navigationManager: NavigationManager,
    navController: NavController,
) {
    LaunchedEffect(key1 = Unit) {
        navigationManager.commands
            .onEach { command ->
                when (command.destination) {
                    PopBackStack.destination -> navController.popBackStack()
                    else -> navController.navigate(route = command.destination)
                }
            }
            .launchIn(this)
    }
}

@Composable
fun BottomNavigation(navController: NavHostController) {
    val options = listOf(
        NavigationBarItem.Profile,
        NavigationBarItem.Movie,
        NavigationBarItem.Location,
        NavigationBarItem.Gallery,
    )
    var selectedItem by remember { mutableStateOf(ProfileNavigation.destination) }
    NavigationBar(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
        containerColor = Yellow,
    ) {
        options.forEach { item ->
            val currentSelected = selectedItem == item.screenRoute
            NavigationBarItem(
                selected = currentSelected,
                onClick = {
                    selectedItem = item.screenRoute
                    navController.navigate(item.screenRoute) {
                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = item.icon),
                        contentDescription = stringResource(id = item.titleRes),
                    )
                },
            )
        }
    }
}
