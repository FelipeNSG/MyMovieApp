package com.example.mymovieapp.movies

data class Movie(
    override var id: Int,
    override val title: String,
    override val url: String,
    override val backdropPath: String,
    override val type: String = "movie"
): MovieAndSeries(
    id,
    title,
    url,
    backdropPath,
    type
)

