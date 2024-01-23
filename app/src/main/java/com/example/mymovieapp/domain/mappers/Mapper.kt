package com.example.mymovieapp.domain.mappers

import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.network.model.Result

fun Result.toMovie(): Movie {
    // mapper
    return Movie(
        id = this.id ?: Int.MIN_VALUE,
        title = this.title ?: "unknown",
        url = this.posterPath ?: "default_url",
        backdropPath = this.backdropPath ?: "default_url"
    )
}

