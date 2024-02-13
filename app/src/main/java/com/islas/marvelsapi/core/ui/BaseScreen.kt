package com.islas.marvelsapi.core.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.islas.marvelsapi.navigation.graphs.HomeNavGraph
import com.islas.marvelsapi.presentation.stateholders.MasterViewModel

@Composable
fun BaseScreen(
    navHostController: NavHostController = rememberNavController(),
    masterViewModel: MasterViewModel,
) {
    Scaffold(
        content = { paddingValues ->
            HomeNavGraph(
                navController = navHostController,
                masterViewModel = masterViewModel,
                innerPadding = paddingValues
            )
        },
        topBar = {
            TopBarComponent(navController = navHostController)
        },
    )
}



@Composable
fun TopBarComponent(navController: NavHostController) {
}
