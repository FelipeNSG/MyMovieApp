package com.example.mymovieapp.movies

data class Series(
    override val id: Int,
    override val title: String,
    override val url: String,
    override val backdropPath: String,
    override val type: String = "series"
): MovieAndSeries(
    id,
    title,
    url,
    backdropPath,
    type
)
