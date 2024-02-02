package com.example.mymovieapp.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.mymovieapp.ui.theme.colorWhite

@Composable
@Preview
fun Profiles() {
    LazyRow(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        items(20) { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .size(90.dp),
                    shape = CircleShape

                ) {
                    SubcomposeAsyncImage(
                        model = "https://picsum.photos/id/235/200/300",
                        contentDescription = null,
                        loading = { CircularProgressIndicator() },
                        modifier = Modifier
                            .clip(CircleShape)
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                }
                Column(
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Text(text = "Nombre Actor", color = colorWhite)
                    Text(text = "Puesto del actor", color = colorWhite)
                }
            }
        }
    }
}