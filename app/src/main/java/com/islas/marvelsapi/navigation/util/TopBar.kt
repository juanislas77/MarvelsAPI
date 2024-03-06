package com.islas.marvelsapi.navigation.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Tv
import androidx.compose.ui.graphics.vector.ImageVector
import com.islas.marvelsapi.R
import com.islas.marvelsapi.navigation.graphs.Graph

sealed class TopBar(
    val route: String,
    val title: Int,
    val icon: ImageVector
) {

    object DASHBOARD : TopBar(
        route = Graph.DASH,
        title = R.string.dashboard,
        icon = Icons.Outlined.Dashboard
    )

    object COMICS: TopBar(
        route = Graph.COMICLIST,
        title = R.string.comics,
        icon = Icons.Outlined.Book
    )

    object CHARACTERS: TopBar(
        route = Graph.CHARACTERLIST,
        title = R.string.characters,
        icon = Icons.Outlined.People
    )

    object SERIES: TopBar(
        route = Graph.SERIESLIST,
        title = R.string.series,
        icon = Icons.Outlined.Tv
    )

    object STORIES: TopBar(
        route = Graph.STORIESLIST,
        title = R.string.stories,
        icon = Icons.Outlined.History
    )
}
