package com.globant.moviedbchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.globant.moviedbchallenge.navigation.HandleNavigationCommands
import com.globant.moviedbchallenge.navigation.MovieNavHost
import com.globant.design.theme.MovieDbChallengueTheme
import com.globant.navigation.NavigationManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    internal lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieDbChallengueTheme {
                val navController = rememberNavController()

                MovieNavHost(navController)
                HandleNavigationCommands(
                    navigationManager = navigationManager,
                    navController = navController,
                )
            }
        }
    }
}
