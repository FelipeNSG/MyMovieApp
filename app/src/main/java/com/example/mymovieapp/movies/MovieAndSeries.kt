package com.example.mymovieapp.movies

open class MovieAndSeries(
    open val id: Int,
    open val title: String,
    open val url: String,
    open val backdropPath: String,
    open val type: String
) {
    fun isUrlValid(): Boolean {
        return url != "default_url"
    }
}