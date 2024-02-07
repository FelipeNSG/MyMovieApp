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
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.mymovieapp.movies.imageMovieUrl
import com.example.mymovieapp.movies.MovieCast
import com.example.mymovieapp.ui.theme.colorWhite

@Composable
fun Profiles(movieCredits: List<MovieCast>) {
    LazyRow(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        items(movieCredits.take(20).size) { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .size(90.dp),
                    shape = CircleShape

                ) {
                    SubcomposeAsyncImage(
                        model = imageMovieUrl(movieCredits[item].profilePath),
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
                    Text(text =  movieCredits[item].originalName, color = colorWhite)
                    Text(text = movieCredits[item].character, color = colorWhite)
                }
            }
        }
    }
}