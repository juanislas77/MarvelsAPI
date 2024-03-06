package com.islas.marvelsapi.navigation.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.islas.marvelsapi.core.ui.BaseScreen
import com.islas.marvelsapi.navigation.graphs.Graph
import com.islas.marvelsapi.presentation.stateholders.MasterViewModel

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    masterViewModel: MasterViewModel
    ){
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.DASH
    ){
        composable(route = Graph.DASH){
            BaseScreen(
                masterViewModel = masterViewModel
            )
        }
    }
}