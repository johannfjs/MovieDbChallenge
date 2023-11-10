package com.globant.navigation.directions

import com.globant.navigation.NavigationCommand

object PopBackStack : NavigationCommand {
    override val destination: String = "popBackStack"
}
