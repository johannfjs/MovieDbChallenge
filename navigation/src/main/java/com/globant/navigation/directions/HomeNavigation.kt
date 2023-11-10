package com.globant.navigation.directions

import com.globant.navigation.NavigationCommand
import com.globant.navigation.NavigationRoute

object HomeNavigation : NavigationRoute, NavigationCommand {
    override val route: String = "home"
    override val destination: String = route
}
