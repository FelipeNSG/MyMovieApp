package com.example.mymovieapp.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.Movie
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = MoviesRepository

    private val _popularMovies = MutableLiveData<List<Movie>>()
    val popularMovies: LiveData<List<Movie>> = _popularMovies

    init {
        getPopularMovies()
    }
    private fun getPopularMovies() {
        viewModelScope.launch {
            val movies = repository.getPopularMovies()
            _popularMovies.value = movies
        }
    }

}