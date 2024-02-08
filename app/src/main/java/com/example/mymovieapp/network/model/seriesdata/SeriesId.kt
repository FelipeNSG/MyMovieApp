package com.example.mymovieapp.network.model.seriesdata


import com.google.gson.annotations.SerializedName

data class SeriesId(
    @SerializedName("number_of_seasons")
    val numberOfSeasons: Int?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("genres")
    val genres: List<Genre?>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("last_air_date")
    val lastAirDate: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("tagline")
    val tagline: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?
)