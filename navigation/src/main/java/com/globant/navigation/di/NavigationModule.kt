package com.globant.navigation.di

import com.globant.navigation.NavigationManager
import com.globant.navigation.NavigationManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {
    @Provides
    fun provideNavigationManager(): NavigationManager = NavigationManagerImpl
}
