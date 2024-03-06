package com.islas.marvelsapi.presentation.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.islas.marvelsapi.navigation.graphs.Graph
import com.islas.marvelsapi.presentation.designsystem.ComicCard
import com.islas.marvelsapi.presentation.stateholders.MasterViewModel

@Composable
fun ComicsListView(
    viewModel: MasterViewModel,
    navHostController: NavHostController,
    innerPadding: PaddingValues
) {
    LaunchedEffect(true) {
        viewModel.getComicsList()
    }

    if (viewModel.comics.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(viewModel.comics.toList()) { characterItem ->
                ComicCard(
                    modifier = Modifier,
                    name = characterItem.title,
                    thumbnail = characterItem.thumbnail.extension,
                    description = characterItem.description,
                    onCardClick = {
                        viewModel.setIdComic(characterItem.id)
                        navHostController.navigate(Graph.COMICDETAIL)
                    })
            }
        }
    } else {
        LoadingView()
    }
}