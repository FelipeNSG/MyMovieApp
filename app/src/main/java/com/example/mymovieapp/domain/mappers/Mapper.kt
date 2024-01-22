package com.example.mymovieapp.domain.mappers

import com.example.mymovieapp.movies.MoviesMostPopular
import com.example.mymovieapp.network.model.Result

fun Result.toMovie(): MoviesMostPopular {
    // mapper
    return MoviesMostPopular(
        id = this.id ?: Int.MIN_VALUE,
        title = this.title ?: "unknown",
        url = this.posterPath ?: "default_url"
    )
}

