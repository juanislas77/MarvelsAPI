package com.islas.marvelsapi.navigation.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.compose.kotlinProject.presentation.views.SeriesDetailView
import com.compose.kotlinProject.presentation.views.SeriesListView
import com.compose.kotlinProject.presentation.views.StoriesListView
import com.compose.kotlinProject.presentation.views.StoryDetailView
import com.islas.marvelsapi.presentation.stateholders.MasterViewModel
import com.islas.marvelsapi.presentation.views.CharacterDetailView
import com.islas.marvelsapi.presentation.views.CharacterListView
import com.islas.marvelsapi.presentation.views.ComicDetailView
import com.islas.marvelsapi.presentation.views.ComicsListView
import com.islas.marvelsapi.presentation.views.DashboardView

@Composable
fun HomeNavGraph(
    navController: NavHostController,
    masterViewModel: MasterViewModel,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.DASH
    ) {
        composable(route = Graph.DASH) {
            DashboardView(
                viewModel = masterViewModel,
                navHostController = navController,
                innerPadding = innerPadding
            )
        }
        composable(route = Graph.CHARACTERLIST) {
            CharacterListView(
                viewModel = masterViewModel,
                navHostController = navController,
                innerPadding = innerPadding
            )
        }
        composable(route = Graph.CHARACTERDETAIL) {
            CharacterDetailView(masterViewModel = masterViewModel, innerPadding = innerPadding)
        }
        composable(route = Graph.COMICLIST) {
            ComicsListView(
                viewModel = masterViewModel,
                navHostController = navController,
                innerPadding = innerPadding
            )
        }
        composable(route = Graph.COMICDETAIL) {
            ComicDetailView(masterViewModel = masterViewModel, innerPadding = innerPadding)
        }
        composable(route = Graph.SERIESLIST) {
            SeriesListView(
                viewModel = masterViewModel,
                navHostController = navController,
                innerPadding = innerPadding
            )
        }
        composable(route = Graph.SERIEDETAIL) {
            SeriesDetailView(masterViewModel = masterViewModel, innerPadding = innerPadding)
        }
        composable(route = Graph.STORIESLIST) {
            StoriesListView(
                viewModel = masterViewModel,
                navHostController = navController,
                innerPadding = innerPadding
            )
        }
        composable(route = Graph.STORYDETAIL) {
            StoryDetailView(masterViewModel = masterViewModel, innerPadding = innerPadding)
        }
    }
}
