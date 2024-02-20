package com.example.mymovieapp.network.model.moviedata

import com.google.gson.annotations.SerializedName

data class MovieId(
    @SerializedName("adult")
    val adult: Boolean? = null,
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    @SerializedName("genres")
    val genres: List<Genre>? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    @SerializedName("runtime")
    val runtime: Int? = null,
    @SerializedName("tagline")
    val tagline: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("vote_average")
    val voteAverage: Double? = null,
)