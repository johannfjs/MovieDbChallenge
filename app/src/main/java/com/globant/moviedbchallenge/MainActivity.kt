package com.globant.moviedbchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.globant.design.theme.MovieDbChallengueTheme
import com.globant.moviedbchallenge.navigation.BottomNavigation
import com.globant.moviedbchallenge.navigation.HandleNavigationCommands
import com.globant.moviedbchallenge.navigation.MovieNavHost
import com.globant.navigation.NavigationManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    internal lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieDbChallengueTheme {
                val navController = rememberNavController()
                Scaffold(bottomBar = { BottomNavigation(navController) }) { padding ->
                    Box(modifier = Modifier.padding(padding)) {
                        MovieNavHost(navController)
                        HandleNavigationCommands(
                            navigationManager = navigationManager,
                            navController = navController,
                        )
                    }
                }
            }
        }
    }
}
