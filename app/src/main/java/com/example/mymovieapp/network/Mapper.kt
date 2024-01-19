package com.example.mymovieapp.network

import com.example.mymovieapp.network.model.Result

data class Movie(
    val id: Int,
    val title: String,
    val url: String
)

fun Result.toMovie(): Movie {
    // mapper
    return Movie(
        id = this.id ?: Int.MIN_VALUE,
        title = this.title ?: "unknown",
        url = this.backdropPath ?: "default_url"
    )
}