package com.islas.marvelsapi.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.islas.marvelsapi.R
import com.islas.marvelsapi.presentation.stateholders.MasterViewModel

@Composable
fun CharacterDetailView(
    masterViewModel: MasterViewModel,
    innerPadding: PaddingValues
) {
    masterViewModel.let {
        it.findCharacter(it.getIdCharacter())
    }

    val characterItem = masterViewModel.singleCharacter
    val comics = characterItem.comics.items
    val series = characterItem.series.items
    val stories = characterItem.stories.items
    val urls = characterItem.urls

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .verticalScroll(state = rememberScrollState())
    ) {

        if (characterItem.thumbnail.path.isBlank()) {
            Image(
                modifier = Modifier
                    .size(320.dp),
                painter = painterResource(id = R.drawable.iron_man),
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center,
                contentDescription = stringResource(R.string.default_image)
            )
        } else {
            SubcomposeAsyncImage(
                modifier = Modifier,
                model = characterItem.thumbnail.path,
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center,
                contentDescription = stringResource(R.string.image_character),
                error = {
                    Image(
                        modifier = Modifier
                            .size(320.dp),
                        painter = painterResource(id = R.drawable.iron_man),
                        contentScale = ContentScale.Fit,
                        alignment = Alignment.Center,
                        contentDescription = stringResource(R.string.default_image)
                    )
                }
            )
        }

        Text(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            text = characterItem.name,
            fontWeight = FontWeight.Medium,
            lineHeight = 50.sp,
            fontSize = 50.sp,
            textAlign = TextAlign.Center
        )
        if (characterItem.description.isNotBlank()) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                text = characterItem.description,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        } else {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                text = stringResource(R.string.description),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        }
        val modified = characterItem.modified
        Text(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            text = "Modified at $modified",
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            textAlign = TextAlign.End
        )
        Text(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            text = characterItem.resourceURI,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            textAlign = TextAlign.End
        )

        if (comics.isNotEmpty()) {
            val countOfComics = comics.size.toString()
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                text = "Number of Comics: $countOfComics",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        }
        if (series.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                text = "Series"
            )
            LazyRow {
                items(series) { seriesItem ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .height(100.dp)
                            .weight(0.35f),
                        elevation = CardDefaults.cardElevation(1.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            text = seriesItem.name,
                            maxLines = 4
                        )
                    }
                }
            }
        }
        if (stories.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(), text = "Stories"
            )
            LazyRow {
                items(stories) { storiesItem ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(0.35f)
                            .height(100.dp),
                        elevation = CardDefaults.cardElevation(1.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            text = storiesItem.name,
                            maxLines = 4
                        )
                    }
                }
            }
        }
        if (urls.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                text = "Other resources"
            )
            LazyRow {
                items(urls) { urlItem ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(0.35f)
                            .height(100.dp),
                        elevation = CardDefaults.cardElevation(1.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            text = urlItem.url,
                            maxLines = 4
                        )

                    }
                }
            }
            Text(text = "")
        }

    }
}
