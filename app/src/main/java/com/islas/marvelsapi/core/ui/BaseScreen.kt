package com.islas.marvelsapi.core.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.islas.marvelsapi.navigation.graphs.HomeNavGraph
import com.islas.marvelsapi.navigation.util.TopBar
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val screens = listOf(
        TopBar.DASHBOARD,
        TopBar.CHARACTERS,
        TopBar.COMICS,
        TopBar.SERIES,
        TopBar.STORIES
    )

    val topBarDestination = screens.any { it.route == currentDestination?.route }
//    if (topBarDestination.not()) {
//        TopAppBar(
//            title = { Text(text = "Marvels Service") },
//            navigationIcon = {
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Return")
//                }
//            }
//        )
//    }
    if (topBarDestination) {
        NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
            screens.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            modifier = Modifier.size(16.dp),
                            imageVector = item.icon,
                            contentDescription = stringResource(id = item.title),
                        )
                    },
                    label = {
                        Text(stringResource(id = item.title))
                    },
                    selected = currentDestination?.hierarchy?.any {
                        it.route == screens[index].route
                    } == true,
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.secondary
                    ),
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(item.route)
                    }
                )
            }
        }
    }
}
