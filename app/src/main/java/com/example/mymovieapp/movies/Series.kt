package com.example.mymovieapp.movies

data class Series(
    val id: Int,
    val title: String,
    val url: String,
    val backdropPath: String,
    val type: String = "series"
): MovieAndSeries(
    id,
    title,
    url,
    backdropPath,
    type
)
