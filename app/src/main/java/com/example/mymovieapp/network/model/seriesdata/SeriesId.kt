package com.example.mymovieapp.network.model.seriesdata


import com.google.gson.annotations.SerializedName

data class SeriesId(
    @SerializedName("number_of_seasons")
    val numberOfSeasons: Int? = null,
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    @SerializedName("genres")
    val genres: List<Genres>? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("first_air_date")
    val firstAirDate: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("tagline")
    val tagline: String? = null,
    @SerializedName("vote_average")
    val voteAverage: Double? = null,
    @SerializedName("episode_run_time")
    val episodeRunTime: List<Int>? = null
)