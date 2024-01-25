package com.islas.marvelsapi.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.islas.marvelsapi.R
import com.islas.marvelsapi.presentation.designsystem.CategoryCard
import com.islas.marvelsapi.presentation.stateholders.MasterViewModel

@Composable
fun DashboardView(
    viewModel: MasterViewModel,
    navHostController: NavHostController,
    innerPadding: PaddingValues
) {
    val categories = listOf("Characters", "Comics", "Series", "Stories")

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.padding(top = 35.dp, bottom = 60.dp),
            text = "Select a category"
        )
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyRow {
                itemsIndexed(categories) { _, category ->
                    CategoryCard(
                        modifier = Modifier,
                        title = category,
                        image = R.drawable.default_image,
                        onCategoryClick = { navHostController.navigate("root_list_$category") }
                    )
                }
            }
        }
    }
}