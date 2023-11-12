package com.globant.navigation.directions

import com.globant.navigation.NavigationCommand
import com.globant.navigation.NavigationRoute

object MovieNavigation : NavigationRoute, NavigationCommand {
    override val route: String = "movie"
    override val destination: String = route
}
