package com.example.mymovieapp.screens.home

import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.movies.Series
import io.mockk.MockKAnnotations.init
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.slot
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

class PresenterImplTest {

    private val view = mockk<HomeContract.View>()
    private val interaction = mockk<HomeContract.Model>()
    private lateinit var presenter: HomeContract.Presenter

    private val slotUpcomingMovies = slot<(List<Movie>) -> Unit>()
    private val slotMostPopular = slot<(List<Movie>) -> Unit>()
    private val slotPlayNowMovies = slot<(List<Movie>) -> Unit>()
    private val slotTopRateMovies = slot<(List<Movie>) -> Unit>()
    private val slotMostPopularSeries = slot<(List<Series>) -> Unit>()

    @Before
    fun setUp() {
        init(this)
        presenter = PresenterImpl(view, interaction)
    }

    @Test
    fun getUpcomingMovies() {
        //arrange
        every {
            interaction.fetchUpcomingMovies(capture(slotUpcomingMovies))
        } answers {
            slotUpcomingMovies.captured.invoke(emptyList())
        }
        every { view.displayUpcomingMovies(any()) } just runs
        //act
        presenter.getUpcomingMovies()
        //assertion
        verify {
            view.displayUpcomingMovies(emptyList())
        }
    }

    @Test
    fun getMostPopular() {
        //arrange
        every {
            interaction.fetchMostPopularMovies(capture(slotMostPopular))
        } answers {
            slotMostPopular.captured.invoke(emptyList())
        }
        every { view.displayMostPopularMovies(any()) } just runs
        //act
        presenter.getMostPopularMovies()
        //assertion
        verify {
            view.displayMostPopularMovies(emptyList())
        }
    }

    @Test
    fun getPlayNowMovies() {
        //arrange
        every {
            interaction.fetchPlayNowMovies(capture(slotPlayNowMovies))
        } answers {
            slotPlayNowMovies.captured.invoke(emptyList())
        }
        every { view.displayPlayNowMovies(any()) } just runs
        //act
        presenter.getPlayNowMovies()
        //assertion
        verify {
            view.displayPlayNowMovies(emptyList())
        }
    }

    @Test
    fun getTopRateMovies() {
        //arrange
        every {
            interaction.fetchTopRateMovies(capture(slotTopRateMovies))
        } answers {
            slotTopRateMovies.captured.invoke(emptyList())
        }
        every { view.displayTopRateMovies(any()) } just runs
        //act
        presenter.getTopRateMovies()
        //assertion
        verify {
            view.displayTopRateMovies(emptyList())
        }
    }

    @Test
    fun getMostPopularSeries() {
        //arrange
        every {
            interaction.fetchMostPopularSeries(capture(slotMostPopularSeries))
        } answers {
            slotMostPopularSeries.captured.invoke(emptyList())
        }
        every { view.displayMostPopularSeries(any()) } just runs
        //act
        presenter.getMostPopularSeries()
        //assertion
        verify {
            view.displayMostPopularSeries(emptyList())
        }

    }

    @After
    fun tearDown() {

    }

}