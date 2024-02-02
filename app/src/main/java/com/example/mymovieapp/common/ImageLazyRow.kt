package com.example.mymovieapp.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

@Composable
@Preview()
fun ImageLazyRow(){
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp),
    ) {

        items(20) { item ->
            Card(
                modifier = Modifier
                    .width(120.dp)
                    .height(180.dp)
                    .padding(end = 10.dp)
                    .clickable {
                    },
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    SubcomposeAsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = "https://picsum.photos/id/234/200/300",
                        contentDescription = null,
                        loading = { CircularProgressIndicator() },
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        }
    }
}