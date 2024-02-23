package com.example.mymovieapp.screens.home

import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.movies.Series
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockkObject
import io.mockk.unmockkObject
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class InteractionImplTest {
    private lateinit var interaction: InteractionImpl
    private val result: List<Movie> = (
            listOf(
                Movie(id = 0, title = "title1", url = "", backdropPath = "", type = "movie"),
                Movie(id = 0, title = "title2", url = "", backdropPath = "", type = "movie"),
                Movie(id = 0, title = "title3", url = "", backdropPath = "", type = "movie"),
                Movie(id = 0, title = "title4", url = "", backdropPath = "", type = "movie"),
                Movie(id = 0, title = "title5", url = "", backdropPath = "", type = "movie")
            )
            )
    private val resultSeries: List<Series> =
        listOf(
            Series(
                id = 9888,
                title = "run",
                url = "http://www.bing.com/search?q=egestas",
                backdropPath = "elite",
                type = "series"
            )
        )

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        interaction = InteractionImpl()
        mockkObject(MoviesRepository)

    }

    @Test
    fun fetchUpcomingMovies() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getUpcomingMovies()
        } coAnswers {
            result
        }
        //act
        interaction.fetchUpcomingMovies {
            //assertion
            Assert.assertEquals(5, it.size)
        }
    }

    @Test
    fun fetchMostPopularMovies() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getPopularMovies()
        } coAnswers {
            result
        }
        //act
        interaction.fetchMostPopularMovies {
            println("Hello")
            //assertion
            Assert.assertEquals(5, it.size)
        }
    }

    @Test
    fun fetchPlayNowMovies() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getPlayNow()
        } coAnswers {
            result
        }
        //act
        interaction.fetchPlayNowMovies {
            //assertion
            Assert.assertEquals(5, it.size)
        }
    }

    @Test
    fun fetchTopRateMovies() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getTopRate()
        } coAnswers {
            result
        }
        //act
        interaction.fetchTopRateMovies {
            //assertion
            Assert.assertEquals(5, it.size)
        }
    }

    @Test
    fun fetchMostPopularSeries() = runTest {
        //arrange
        coEvery {
            MoviesRepository.getPopularSeries()
        } coAnswers {
            resultSeries
        }
        //act
        interaction.fetchMostPopularSeries {
            print("hola")
            //assertion
            Assert.assertEquals(1, it.size)
        }
    }

    @After
    fun tearDown() {
        unmockkObject(MoviesRepository)
    }
}