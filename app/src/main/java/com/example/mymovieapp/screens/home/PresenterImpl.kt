package com.example.mymovieapp.screens.home

class PresenterImpl(
    private val view: HomeContract.View,
    private val interaction: HomeContract.Model
) :
    HomeContract.Presenter {
    override fun initPresenterFunctions() {
        getUpcomingMovies()
        getMostPopularMovies()
        getPlayNowMovies()
        getTopRateMovies()
        getMostPopularSeries()
    }

    override fun getUpcomingMovies() {
        interaction.fetchUpcomingMovies {
            view.displayUpcomingMovies(it)
        }
    }

    override fun getMostPopularMovies() {
        interaction.fetchMostPopularMovies {
            view.displayMostPopularMovies(it)
        }
    }

    override fun getPlayNowMovies() {
        interaction.fetchPlayNowMovies {
            view.displayPlayNowMovies(it)
        }
    }

    override fun getTopRateMovies() {
        interaction.fetchTopRateMovies {
            view.displayTopRateMovies(it)
        }
    }

    override fun getMostPopularSeries() {
        interaction.fetchMostPopularSeries {
            view.displayMostPopularSeries(it)
        }
    }
}