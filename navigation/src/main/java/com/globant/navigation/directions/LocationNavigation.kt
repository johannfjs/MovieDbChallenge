package com.globant.navigation.directions

import com.globant.navigation.NavigationCommand
import com.globant.navigation.NavigationRoute

object LocationNavigation : NavigationRoute, NavigationCommand {
    override val route: String = "location"
    override val destination: String = route
}
