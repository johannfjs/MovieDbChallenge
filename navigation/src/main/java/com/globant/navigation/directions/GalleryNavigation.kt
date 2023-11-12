package com.globant.navigation.directions

import com.globant.navigation.NavigationCommand
import com.globant.navigation.NavigationRoute

object GalleryNavigation : NavigationRoute, NavigationCommand {
    override val route: String = "gallery"
    override val destination: String = route
}
