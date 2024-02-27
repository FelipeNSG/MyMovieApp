package com.example.mymovieapp.data.repository

import com.example.mymovieapp.MOCKKS
import com.example.mymovieapp.domain.mappers.toMovieDetails
import com.example.mymovieapp.network.client.MovieClient
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockkObject
import io.mockk.unmockkObject
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MoviesRepositoryTest {

    @Before
    fun setUp() {
        init(this)
        mockkObject(MovieClient)
    }

    @Test
    fun `Given a MovieRepository service when call getPopularMovies() then return a List Movie `() =
        runTest {
            val movieList = MOCKKS.movieListSuccess
            //arrange
            coEvery {
                MovieClient.createMoviesService().getPopularMovies()
            } returns movieList
            //act
            val result = MoviesRepository.getPopularMovies()
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getPopularMovies() }
            Assert.assertTrue(
                result.size == movieList.results?.size
            )
        }

    @Test
    fun `Given a MovieRepository service when call getTopRate() then throws HttpException and return a emptyList `() =
        runTest {
            coEvery {
                MovieClient.createMoviesService().getPopularMovies()
            }.throws(
                ex = MOCKKS.HttpException
            )
            //act
            val result = MoviesRepository.getPopularMovies()
            ///Assert
            coVerify(exactly = 1) {
                MovieClient.createMoviesService().getPopularMovies()
            }
            Assert.assertTrue(
                result.isEmpty()
            )
        }

    @Test
    fun `Given a MovieRepository service when call getTopRate() then return a List Movie `() =
        runTest {
            val movieList = MOCKKS.movieListSuccess
            //arrange
            coEvery {
                MovieClient.createMoviesService().getTopRate()
            } returns movieList
            //act
            val result = MoviesRepository.getTopRate()
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getTopRate() }
            Assert.assertTrue(
                result.size == movieList.results?.size
            )
        }

    @Test
    fun `Given a MovieRepository service when call getTopRate() then throws HttpException and return a emptyList`() =
        runTest {
            coEvery {
                MovieClient.createMoviesService().getTopRate()
            }.throws(
                ex = MOCKKS.HttpException
            )
            //act
            val result = MoviesRepository.getTopRate()

            ///Assert
            coVerify(exactly = 1) {
                MovieClient.createMoviesService().getTopRate()
            }
            Assert.assertTrue(
                result.isEmpty()
            )
        }

    @Test
    fun `Given a MovieRepository service when call getPopularSeries() then return a List of Movie`() =
        runTest {
            val seriesList = MOCKKS.movieListSuccess
            //arrange
            coEvery {
                MovieClient.createMoviesService().getPopularSeries()
            } returns seriesList
            //act
            val result = MoviesRepository.getPopularSeries()
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getPopularSeries() }
            Assert.assertTrue(
                result.size == seriesList.results?.size
            )
        }

    @Test
    fun `Given a MovieRepository service when call getPopularSeries() then throws HttpException and return a emptyList`() =
        runTest {
            coEvery {
                MovieClient.createMoviesService().getPopularSeries()
            }.throws(
                ex = MOCKKS.HttpException
            )
            //act
            val result = MoviesRepository.getPopularSeries()
            ///Assert
            coVerify(exactly = 1) {
                MovieClient.createMoviesService().getPopularSeries()
            }
            Assert.assertTrue(
                result.isEmpty()
            )
        }

    @Test
    fun `Given a MovieRepository service when call getUpcomingMovies() then return a List of Movie`() =
        runTest {
            val movieListWithDate = MOCKKS.movieListWithDateSuccess
            //arrange
            coEvery {
                MovieClient.createMoviesService().getUpcomingMovies()
            } returns movieListWithDate
            //act
            val result = MoviesRepository.getUpcomingMovies()
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getUpcomingMovies() }
            Assert.assertTrue(
                result.size == movieListWithDate.results?.size
            )
        }

    @Test
    fun `Given a MovieRepository service when call getUpcomingMovies() then throws HttpException and return a emptyList`() =
        runTest {
            coEvery {
                MovieClient.createMoviesService().getUpcomingMovies()
            }.throws(
                ex = MOCKKS.HttpException
            )
            //act
            val result = MoviesRepository.getUpcomingMovies()
            ///Assert
            coVerify(exactly = 1) {
                MovieClient.createMoviesService().getUpcomingMovies()
            }
            Assert.assertTrue(
                result.isEmpty()
            )
        }

    @Test
    fun `Given a MovieRepository service when call getPlayNow() then return a List of Movie`() =
        runTest {
            val movieListWithDate = MOCKKS.movieListWithDateSuccess
            //arrange
            coEvery {
                MovieClient.createMoviesService().getPlayNow()
            } returns movieListWithDate
            //act
            val result = MoviesRepository.getPlayNow()
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getPlayNow() }
            Assert.assertTrue(
                result.size == movieListWithDate.results?.size
            )
        }

    @Test
    fun `Given a MovieRepository service when call getPlayNow() then throws HttpException and return a emptyList`() =
        runTest {
            coEvery {
                MovieClient.createMoviesService().getPlayNow()
            }.throws(
                ex = MOCKKS.HttpException
            )
            //act
            val result = MoviesRepository.getPlayNow()
            ///Assert
            coVerify(exactly = 1) {
                MovieClient.createMoviesService().getPlayNow()
            }
            Assert.assertTrue(
                result.isEmpty()
            )
        }

    @Test
    fun `Given a MovieRepository service when call getMovieDetails then return a MovieAndSeriesDetails`() =
        runTest {
            val movieAndSeriesDetails = MOCKKS.resultMovieId
            val mappedObject = movieAndSeriesDetails.toMovieDetails()
            //arrange
            coEvery {
                MovieClient.createMoviesService().getMovieDetails(any())
            } returns movieAndSeriesDetails
            //act
            val result = MoviesRepository.getMovieDetails(1111)
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getMovieDetails(any()) }
            Assert.assertNotNull { result }.also { Assert.assertTrue(result?.type == mappedObject.type) }
        }

    @After
    fun tearDown() {
        unmockkObject(MovieClient)
    }
}