package com.globant.moviedbchallenge.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.globant.design.R
import com.globant.navigation.directions.GalleryNavigation
import com.globant.navigation.directions.LocationNavigation
import com.globant.navigation.directions.MovieNavigation
import com.globant.navigation.directions.ProfileNavigation

sealed class NavigationBarItem(
    @StringRes var titleRes: Int,
    @DrawableRes var icon: Int,
    var screenRoute: String,
) {
    object Profile :
        NavigationBarItem(
            R.string.profile,
            R.drawable.ic_profile,
            ProfileNavigation.destination,
        )

    object Movie :
        NavigationBarItem(
            R.string.movie,
            R.drawable.ic_movie,
            MovieNavigation.destination,
        )

    object Location :
        NavigationBarItem(
            R.string.location,
            R.drawable.ic_location,
            LocationNavigation.destination,
        )

    object Gallery :
        NavigationBarItem(
            R.string.gallery,
            R.drawable.ic_gallery,
            GalleryNavigation.destination,
        )
}
