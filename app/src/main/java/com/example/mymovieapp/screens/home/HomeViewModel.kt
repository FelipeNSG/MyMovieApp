package com.example.mymovieapp.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.movies.Series
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = MoviesRepository
    private val _popularMovies = MutableLiveData<List<Movie>>()
    private val _listPlayNow = MutableLiveData<List<Movie>>()
    private val _listUpcoming = MutableLiveData<List<Movie>>()
    private val _listTopRate = MutableLiveData<List<Movie>>()
    private val _listMostPopularSeries = MutableLiveData<List<Series>>()

    val popularMovies: LiveData<List<Movie>>
        get() = _popularMovies
    val listPlayNow: LiveData<List<Movie>>
        get() = _listPlayNow
    val listUpcoming: LiveData<List<Movie>>
        get() = _listUpcoming
    val listTopRate: LiveData<List<Movie>>
        get() = _listTopRate
    val listMostPopularSeries: LiveData<List<Series>>
        get() = _listMostPopularSeries

    init {
        getPopularMovies()
        getListPlayNow()
        getListUpcoming()
        getListTopRate()
        listMostPopularSeries()
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            val movies = repository.getPopularMovies()
            _popularMovies.value = movies
        }
    }

    private fun getListPlayNow() {
        viewModelScope.launch {
            val movies = repository.getPlayNow()
            _listPlayNow.value = movies
        }
    }

    private fun getListUpcoming() {
        viewModelScope.launch {
            val movies = repository.getUpcomingMovies()
            _listUpcoming.value = movies
        }
    }

private fun getListTopRate() {
        viewModelScope.launch {
            val movies = repository.getTopRate()
            _listTopRate.value = movies
        }
    }

    private fun listMostPopularSeries() {
        viewModelScope.launch {
            val series = repository.getPopularSeries()
            _listMostPopularSeries.value = series
        }
    }
}