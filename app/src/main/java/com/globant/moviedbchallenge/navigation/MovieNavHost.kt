package com.globant.moviedbchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.globant.feature.home.HomeScreen
import com.globant.navigation.NavigationManager
import com.globant.navigation.directions.HomeNavigation
import com.globant.navigation.directions.PopBackStack
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun MovieNavHost(navController: NavHostController) {
    NavHost(
        navController,
        startDestination = HomeNavigation.destination,
    ) {
        composable(HomeNavigation.route) { HomeScreen() }
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
