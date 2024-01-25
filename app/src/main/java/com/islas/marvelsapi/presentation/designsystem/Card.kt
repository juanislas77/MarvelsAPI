package com.islas.marvelsapi.presentation.designsystem

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

@Composable
fun CharacterCard(
    modifier: Modifier,
    name: String,
    thumbnail: String?,
    description: String?,
    onCardClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(6.dp)
            .clickable { onCardClick.invoke() },
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (thumbnail.isNullOrBlank()) {
                Image(
                    modifier = Modifier
                        .size(320.dp),
                    painter = painterResource(id = R.drawable.default_image),
                    contentScale = ContentScale.Crop,
                    contentDescription = stringResource(R.string.default_image)
                )
            } else {
                SubcomposeAsyncImage(
                    modifier = Modifier,
                    model = thumbnail,
                    contentScale = ContentScale.Fit,
                    contentDescription = stringResource(R.string.image_character),
                    error = {
                        Image(
                            modifier = Modifier
                                .size(320.dp),
                            painter = painterResource(id = R.drawable.default_image),
                            contentScale = ContentScale.Fit,
                            contentDescription = stringResource(R.string.default_image)
                        )
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                )
                if (!description.isNullOrBlank()) {
                    Text(
                        text = description,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                } else {
                    Text(
                        text = stringResource(R.string.description),
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ComicCard(
    modifier: Modifier,
    name: String,
    thumbnail: String?,
    description: String?,
    onCardClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(6.dp)
            .clickable { onCardClick.invoke() },
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (thumbnail.isNullOrBlank()) {
                    Image(
                        modifier = Modifier
                            .size(100.dp),
                        painter = painterResource(id = R.drawable.default_image),
                        contentScale = ContentScale.Crop,
                        contentDescription = stringResource(R.string.default_image)
                    )
                } else {
                    SubcomposeAsyncImage(
                        modifier = Modifier,
                        model = thumbnail,
                        contentScale = ContentScale.Fit,
                        contentDescription = stringResource(R.string.image_character),
                        error = {
                            Image(
                                modifier = Modifier
                                    .size(100.dp),
                                painter = painterResource(id = R.drawable.default_image),
                                contentScale = ContentScale.Fit,
                                contentDescription = stringResource(R.string.default_image)
                            )
                        }
                    )
                }
                if (!description.isNullOrBlank()) {
                    Text(
                        text = description,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                } else {
                    Text(
                        text = stringResource(R.string.comic_description),
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryCard(
    modifier: Modifier,
    title: String,
    image: Int,
    onCategoryClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(6.dp)
            .clickable { onCategoryClick.invoke() },
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .size(200.dp),
                painter = painterResource(id = image),
                contentScale = ContentScale.Fit,
                contentDescription = stringResource(R.string.default_image)
            )
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = title,
                fontWeight = FontWeight.Medium,
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )
        }

    }
}