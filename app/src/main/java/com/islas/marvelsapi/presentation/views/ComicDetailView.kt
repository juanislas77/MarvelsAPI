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
fun ComicDetailView(
    masterViewModel: MasterViewModel,
    innerPadding: PaddingValues
) {
    masterViewModel.let {
        it.findComic(it.getIdComic())
    }

    val comic = masterViewModel.singleComic
    val description = comic.description
    val format = comic.format
    val creators = comic.creators.items
    val images = comic.images
    val series = comic.series.name
    val stories = comic.stories.items

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .verticalScroll(state = rememberScrollState())
    ) {
        if (comic.thumbnail.path.isBlank()){
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
                model = comic.thumbnail.path,
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
            text = comic.title,
            fontWeight = FontWeight.Medium,
            lineHeight = 50.sp,
            fontSize = 50.sp,
            textAlign = TextAlign.Center
        )
        if (!comic.description.isNullOrBlank()) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                text = comic.description,
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
        if (comic.series.name.isNotBlank()) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                text = comic.series.name,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        } else {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                text = stringResource(R.string.no_series_provided),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        }
        if (creators.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                text = "Creators"
            )
            LazyRow {
                items(creators) { creatorsItem ->
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
                            text = creatorsItem.name,
                            maxLines = 4
                        )
                    }
                }
            }
        }
        if (images.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                text = "Images"
            )
            LazyRow {
                items(images) { imagesItem ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .height(100.dp)
                            .weight(0.35f),
                        elevation = CardDefaults.cardElevation(1.dp)
                    ) {
                        SubcomposeAsyncImage(
                            modifier = Modifier,
                            model = imagesItem,
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
                }
            }
        }
        if (stories.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                text = "Stories"
            )
            LazyRow {
                items(creators) { storiesItem ->
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
                            text = storiesItem.name,
                            maxLines = 4
                        )
                    }
                }
            }
        }
    }

}