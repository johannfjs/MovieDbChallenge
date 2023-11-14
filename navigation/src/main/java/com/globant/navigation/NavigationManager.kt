package com.globant.navigation

import com.globant.navigation.directions.PopBackStack
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

interface NavigationManager {
    val commands: Flow<NavigationCommand>
    fun navigate(direction: NavigationCommand)
    fun popBackStack()
}

internal object NavigationManagerImpl : NavigationManager {
    override val commands = MutableSharedFlow<NavigationCommand>(extraBufferCapacity = 64)

    override fun navigate(direction: NavigationCommand) {
        commands.tryEmit(direction)
    }

    override fun popBackStack() {
        commands.tryEmit(PopBackStack)
    }
}
