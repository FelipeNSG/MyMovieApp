package com.example.mymovieapp.data.repository

import com.example.mymovieapp.MOCKKS
import com.example.mymovieapp.domain.mappers.toMovieAndSeriesImagePoster
import com.example.mymovieapp.domain.mappers.toMovieDetails
import com.example.mymovieapp.domain.mappers.toSeriesDetails
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
    fun `Given a MovieRepository service when call getPopularMovies() then return a emptyList `() =
        runTest {
            val movieList = MOCKKS.movieListNotSuccess
            //arrange
            coEvery {
                MovieClient.createMoviesService().getPopularMovies()
            } returns movieList
            //act
            val result = MoviesRepository.getPopularMovies()
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getPopularMovies() }
            Assert.assertTrue(
                result.isEmpty()
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
    fun `Given a MovieRepository service when call getTopRate() then return a emptyList `() =
        runTest {
            val movieList = MOCKKS.movieListNotSuccess
            //arrange
            coEvery {
                MovieClient.createMoviesService().getTopRate()
            } returns movieList
            //act
            val result = MoviesRepository.getTopRate()
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getTopRate() }
            Assert.assertTrue(
                result.isEmpty()
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
    fun `Given a MovieRepository service when call getPopularSeries() then return a emptyList()`() =
        runTest {
            val seriesList = MOCKKS.movieListNotSuccess
            //arrange
            coEvery {
                MovieClient.createMoviesService().getPopularSeries()
            } returns seriesList
            //act
            val result = MoviesRepository.getPopularSeries()
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getPopularSeries() }
            Assert.assertTrue(
                result.isEmpty()
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
    fun `Given a MovieRepository service when call getUpcomingMovies() then return a List of emptyList()`() =
        runTest {
            val movieListWithDate = MOCKKS.movieListWithDateNotSuccess
            //arrange
            coEvery {
                MovieClient.createMoviesService().getUpcomingMovies()
            } returns movieListWithDate
            //act
            val result = MoviesRepository.getUpcomingMovies()
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getUpcomingMovies() }
            Assert.assertTrue(
                result.isEmpty()
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
    fun `Given a MovieRepository service when call getPlayNow() then return a emptyList`() =
        runTest {
            val movieListWithDate = MOCKKS.movieListWithDateNotSuccess
            //arrange
            coEvery {
                MovieClient.createMoviesService().getPlayNow()
            } returns movieListWithDate
            //act
            val result = MoviesRepository.getPlayNow()
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getPlayNow() }
            Assert.assertTrue(
                result.isEmpty()
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
    fun `Given a MovieRepository service when call getMovieDetails() then return a MovieAndSeriesDetails`() =
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
            Assert.assertNotNull { result }
                .also { Assert.assertTrue(result?.type == mappedObject.type) }
        }

    @Test
    fun `Given a MovieRepository service when call getMovieDetails() then throws HttpException and return a null`() =
        runTest {
            coEvery {
                MovieClient.createMoviesService().getMovieDetails(any())
            }.throws(
                ex = MOCKKS.HttpException
            )
            //act
            val result = MoviesRepository.getMovieDetails(1000)
            ///Assert
            coVerify(exactly = 1) {
                MovieClient.createMoviesService().getMovieDetails(any())
            }
            Assert.assertNull(
                result
            )
        }

    @Test
    fun `Given a MovieRepository service when call getSeriesDetails() then return a MovieAndSeriesDetails`() =
        runTest {
            val movieAndSeriesDetails = MOCKKS.resultSeriesId
            val mappedObject = movieAndSeriesDetails.toSeriesDetails()
            //arrange
            coEvery {
                MovieClient.createMoviesService().getSeriesDetails(any())
            } returns movieAndSeriesDetails
            //act
            val result = MoviesRepository.getSeriesDetails(1111)
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getSeriesDetails(any()) }
            Assert.assertNotNull { result }
                .also { Assert.assertTrue(result?.type == mappedObject.type) }
        }

    @Test
    fun `Given a MovieRepository service when call getSeriesDetails() then throws HttpException and return a null`() =
        runTest {
            coEvery {
                MovieClient.createMoviesService().getSeriesDetails(any())
            }.throws(
                ex = MOCKKS.HttpException
            )
            //act
            val result = MoviesRepository.getSeriesDetails(1000)
            ///Assert
            coVerify(exactly = 1) {
                MovieClient.createMoviesService().getSeriesDetails(any())
            }
            Assert.assertNull(
                result
            )
        }

    @Test
    fun `Given a MovieRepository service when call getMovieCredits() then return a MovieCast List`() =
        runTest {
            val movieCastList = MOCKKS.resultMovieAndSeriesCredits
            //arrange
            coEvery {
                MovieClient.createMoviesService().getMovieCredits(any())
            } returns movieCastList
            //act=
            val result = MoviesRepository.getMovieCredits(1111)
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getMovieCredits(any()) }
            Assert.assertTrue(
                result.size == movieCastList.cast?.size
            )
        }

    @Test
    fun `Given a MovieRepository service when call getMovieCredits() then return a emptyList()`() =
        runTest {
            val movieCastList = MOCKKS.resultMovieAndSeriesCreditsNotSuccess
            //arrange
            coEvery {
                MovieClient.createMoviesService().getMovieCredits(any())
            } returns movieCastList
            //act=
            val result = MoviesRepository.getMovieCredits(1111)
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getMovieCredits(any()) }
            Assert.assertTrue(
                result.isEmpty()
            )
        }

    @Test
    fun `Given a MovieRepository service when call getMovieCredits() then throws HttpException and return a emptyList`() =
        runTest {
            coEvery {
                MovieClient.createMoviesService().getMovieCredits(any())
            }.throws(
                ex = MOCKKS.HttpException
            )
            //act
            val result = MoviesRepository.getMovieCredits(1111)
            ///Assert
            coVerify(exactly = 1) {
                MovieClient.createMoviesService().getMovieCredits(any())
            }
            Assert.assertTrue(
                result.isEmpty()
            )
        }

    @Test
    fun `Given a MovieRepository service when call getSeriesCredits() then return a MovieCast List`() =
        runTest {
            val seriesCastList = MOCKKS.resultMovieAndSeriesCredits
            //arrange
            coEvery {
                MovieClient.createMoviesService().getSeriesCredits(any())
            } returns seriesCastList
            //act=
            val result = MoviesRepository.getSeriesCredits(1111)
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getSeriesCredits(any()) }
            Assert.assertTrue(
                result.size == seriesCastList.cast?.size
            )
        }

    @Test
    fun `Given a MovieRepository service when call getSeriesCredits() then return a emptyList()`() =
        runTest {
            val seriesCastList = MOCKKS.resultMovieAndSeriesCreditsNotSuccess
            //arrange
            coEvery {
                MovieClient.createMoviesService().getSeriesCredits(any())
            } returns seriesCastList
            //act=
            val result = MoviesRepository.getSeriesCredits(1111)
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getSeriesCredits(any()) }
            Assert.assertTrue(
               result.isEmpty()
            )
        }

    @Test
    fun `Given a MovieRepository service when call getSeriesCredits() then throws HttpException and return a emptyList`() =
        runTest {
            coEvery {
                MovieClient.createMoviesService().getSeriesCredits(any())
            }.throws(
                ex = MOCKKS.HttpException
            )
            //act
            val result = MoviesRepository.getSeriesCredits(1111)
            ///Assert
            coVerify(exactly = 1) {
                MovieClient.createMoviesService().getSeriesCredits(any())
            }
            Assert.assertTrue(
                result.isEmpty()
            )
        }

    @Test
    fun `Given a MovieRepository service when call getMovieImagesPoster() then return a MovieAndSeriesImagePoster List`() =
        runTest {
            val resultMovieImagePoster = MOCKKS.resultMovieAndSeriesImages
            //arrange
            coEvery {
                MovieClient.createMoviesService().getMovieImagesPoster(any())
            } returns resultMovieImagePoster
            //act=
            val result = MoviesRepository.getMovieImagesPoster(1111)
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getMovieImagesPoster(any()) }
            Assert.assertTrue(
                result.size == resultMovieImagePoster.posters?.mapNotNull { it?.toMovieAndSeriesImagePoster() }?.size
            )
        }

    @Test
    fun `Given a MovieRepository service when call getMovieImagesPoster() then return a emptyList()`() =
        runTest {
            val resultMovieImagePoster = MOCKKS.resultMovieAndSeriesImagesNotSuccess
            //arrange
            coEvery {
                MovieClient.createMoviesService().getMovieImagesPoster(any())
            } returns resultMovieImagePoster
            //act=
            val result = MoviesRepository.getMovieImagesPoster(1111)
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getMovieImagesPoster(any()) }
            Assert.assertTrue(
                result.isEmpty()
            )
        }

    @Test
    fun `Given a MovieRepository service when call getMovieImagesPoster() then throws HttpException and return a emptyList`() =
        runTest {
            coEvery {
                MovieClient.createMoviesService().getMovieImagesPoster(any())
            }.throws(
                ex = MOCKKS.HttpException
            )
            //act
            val result = MoviesRepository.getMovieImagesPoster(1111)
            ///Assert
            coVerify(exactly = 1) {
                MovieClient.createMoviesService().getMovieImagesPoster(any())
            }
            Assert.assertTrue(
                result.isEmpty()
            )
        }

    @Test
    fun `Given a MovieRepository service when call getSeriesImagesPoster() then return a MovieAndSeriesImagePoster List`() =
        runTest {
            val resultSeriesImagePoster = MOCKKS.resultMovieAndSeriesImages
            //arrange
            coEvery {
                MovieClient.createMoviesService().getSeriesImagesPoster(any())
            } returns resultSeriesImagePoster
            //act=
            val result = MoviesRepository.getSeriesImagesPoster(1111)
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getSeriesImagesPoster(any()) }
            Assert.assertTrue(
                result.size == resultSeriesImagePoster.posters?.mapNotNull { it?.toMovieAndSeriesImagePoster() }?.size
            )
        }

    @Test
    fun `Given a MovieRepository service when call getSeriesImagesPoster() then return a emptyList()`() =
        runTest {
            val resultSeriesImagePoster = MOCKKS.resultMovieAndSeriesImagesNotSuccess
            //arrange
            coEvery {
                MovieClient.createMoviesService().getSeriesImagesPoster(any())
            } returns resultSeriesImagePoster
            //act=
            val result = MoviesRepository.getSeriesImagesPoster(1111)
            //assertion
            coVerify(exactly = 1) { MovieClient.createMoviesService().getSeriesImagesPoster(any()) }
            Assert.assertTrue(
                result.isEmpty()
            )
        }

    @Test
    fun `Given a MovieRepository service when call getSeriesImagesPoster() then throws HttpException and return a emptyList`() =
        runTest {
            coEvery {
                MovieClient.createMoviesService().getSeriesImagesPoster(any())
            }.throws(
                ex = MOCKKS.HttpException
            )
            //act
            val result = MoviesRepository.getSeriesImagesPoster(1111)
            ///Assert
            coVerify(exactly = 1) {
                MovieClient.createMoviesService().getSeriesImagesPoster(any())
            }
            Assert.assertTrue(
                result.isEmpty()
            )
        }

    @After
    fun tearDown() {
        unmockkObject(MovieClient)
    }
}