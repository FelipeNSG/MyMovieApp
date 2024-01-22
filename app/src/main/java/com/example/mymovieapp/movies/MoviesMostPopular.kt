package com.example.mymovieapp.movies

import com.example.mymovieapp.data.repository.MoviesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

data class MoviesMostPopular(
    val id: Int,
    val title: String,
    val url: String
)

