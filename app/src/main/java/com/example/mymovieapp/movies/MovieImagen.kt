package com.example.mymovieapp.movies

import com.example.mymovieapp.data.repository.MoviesRepository

fun imagenMovieUrl(url: String): String{

    return "https://image.tmdb.org/t/p/original$url"
}


