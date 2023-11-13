package com.globant.feature.home.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.globant.feature.home.profile.ui.ProfileContent

@Composable
fun ProfileScreen() {
    val viewModel = hiltViewModel<ProfileViewModel>()
    val account = viewModel.account.collectAsState().value

    ProfileContent(viewModel = viewModel, account = account)
}
