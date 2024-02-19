package com.example.mymovieapp.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.MovieAndSeriesImagePoster
import com.example.mymovieapp.movies.MovieCast
import com.example.mymovieapp.movies.details.MovieAndSeriesDetails
import kotlinx.coroutines.launch

//TODO("DELETE THIS CLASS")
class DetailsViewModel(var id: Int, private val repository: MoviesRepository, var type: String) :
    ViewModel() {
    init {
        getMovieAndSeriesDetails()
    }

    private val _movieAndSeries = MutableLiveData<MovieDetailsState>()
    val movieAndSeriesDetails: LiveData<MovieDetailsState>
        get() = _movieAndSeries

    private fun getMovieAndSeriesDetails() {
        viewModelScope.launch {
            if (type == "movie") {
                val movieDetails = repository.getMovieDetails(id)
                val movieCredits =
                    repository.getMovieCredits(id).filter { it.profilePath != "defaultProfilePath" }
                val movieAndSeriesImagePoster =
                    repository.getMovieImagesPoster(id).filter { it.iso6391 == "en" }
                        .shuffled()
                if (movieDetails != null) {
                    _movieAndSeries.value = MovieDetailsState.Success(
                        movieDetails,
                        movieCredits,
                        movieAndSeriesImagePoster
                    )
                }
            } else if (type == "series") {
                val movieDetails = repository.getSeriesDetails(id)
                val movieCredits = repository.getSeriesCredits(id)
                    .filter { it.profilePath != "defaultProfilePath" }
                val movieAndSeriesImagePoster =
                    repository.getSeriesImagesPoster(id).filter { it.iso6391 == "en" }
                        .shuffled()
                if (movieDetails != null) {
                    _movieAndSeries.value = MovieDetailsState.Success(
                        movieDetails,
                        movieCredits,
                        movieAndSeriesImagePoster
                    )
                }
            }
        }
    }

    sealed class MovieDetailsState {
        object Loading : MovieDetailsState() {
        }

        data class Success(
            val details: MovieAndSeriesDetails,
            val credits: List<MovieCast>,
            val imagePoster: List<MovieAndSeriesImagePoster>
        ) : MovieDetailsState()
    }
}

class MyViewModelFactory(val id: Int, val type: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            DetailsViewModel(id, repository = MoviesRepository, type) as T

        } else throw Exception("Error Factory")
    }
}