package com.example.mymovieapp.screens.home

class PresenterImpl : HomeContract.Presenter {

    private lateinit var view: HomeContract.View
    private val interaction: HomeContract.Model = InteractionImpl()

    init {
        getUpcomingMovies()
        getMostPopularMovies()
        getPlayNowMovies()
        getTopRateMovies()
        getMostPopularSeries()
    }

    override fun setView(view: HomeContract.View) {
        this.view = view
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