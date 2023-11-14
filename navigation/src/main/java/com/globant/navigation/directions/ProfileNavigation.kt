package com.globant.navigation.directions

import com.globant.navigation.NavigationCommand
import com.globant.navigation.NavigationRoute

object ProfileNavigation : NavigationRoute, NavigationCommand {
    override val route: String = "profile"
    override val destination: String = route
}
