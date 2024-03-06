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
import com.islas.marvelsapi.presentation.designsystem.CharacterCard
import com.islas.marvelsapi.presentation.stateholders.MasterViewModel

@Composable
fun CharacterListView(
    viewModel: MasterViewModel,
    navHostController: NavHostController,
    innerPadding: PaddingValues
) {
    LaunchedEffect(true) {
        viewModel.getCharacterList()
    }

    if (viewModel.characters.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(viewModel.characters.toList()) { characterItem ->
                CharacterCard(
                    modifier = Modifier,
                    name = characterItem.name,
                    thumbnail = characterItem.thumbnail.extension,
                    description = characterItem.description,
                    onCardClick = {
                        viewModel.setIdCharacter(characterItem.id)
                        navHostController.navigate(Graph.CHARACTERDETAIL)
                    })
            }
        }
    } else {
        LoadingView()
    }
}
