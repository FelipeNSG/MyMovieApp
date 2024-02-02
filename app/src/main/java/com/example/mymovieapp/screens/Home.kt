package com.example.mymovieapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import com.example.mymovieapp.R
import com.example.mymovieapp.common.BottomBar
import com.example.mymovieapp.common.TopAppBarSearch
import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.movies.MovieAndSeries
import com.example.mymovieapp.movies.Series
import com.example.mymovieapp.movies.imageMovieUrl
import com.example.mymovieapp.navigation.AppScreen
import com.example.mymovieapp.ui.theme.containerColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediaScreen(navController: NavHostController) {
    var movieListState by remember {
        mutableStateOf(emptyList<Movie>())
    }
    var listMostPopular by remember {
        mutableStateOf(emptyList<Movie>())
    }
    var listPlayNow by remember {
        mutableStateOf(emptyList<Movie>())
    }
    var listTopRate by remember {
        mutableStateOf(emptyList<Movie>())
    }
    var listMostPopularSeries by remember {
        mutableStateOf(emptyList<Series>())
    }
    LaunchedEffect(Unit) {
        movieListState = MoviesRepository.getUpcomingMovies()
        listMostPopular = MoviesRepository.getPopularMovies()
        listPlayNow = MoviesRepository.getPlayNow()
        listTopRate = MoviesRepository.getTopRate()
        listMostPopularSeries = MoviesRepository.getPopularSeries()
    }
    Scaffold(
        containerColor = containerColor,
        topBar = {
            TopAppBarSearch()
        },
        bottomBar = { BottomBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            ContentBoxCarousel(movieListState = movieListState)
            Categories()
            ContentColumnMovieList(
                movieList = listMostPopular,
                title = stringResource(id = R.string.list_most_popular),
                navController = navController
            )
            ContentColumnMovieList(
                movieList = listPlayNow,
                title = stringResource(id = R.string.list_play_now),
                navController = navController
            )
            ContentColumnMovieList(
                movieList = listTopRate,
                title = stringResource(id = R.string.list_top_rate),
                navController = navController
            )
            ContentColumnMovieList(
                movieList = listMostPopularSeries,
                title = stringResource(id = R.string.list_most_popular_series),
                navController = navController
            )
        }
    }
}

@Composable
fun ContentColumnMovieList(
    navController: NavHostController,
    movieList: List<MovieAndSeries>,
    title: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        ListMovies(movieAndSeries = movieList, title = title, navController = navController)
    }
}

@Composable
fun ContentBoxCarousel(movieListState: List<Movie>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(290.dp)
    ) {
        if (movieListState.isNotEmpty()) Carousel(sliderList = movieListState.take(5))
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Carousel(sliderList: List<Movie>) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 2)
    Column {
        HorizontalPager(
            count = sliderList.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 50.dp),
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        ) { page ->
            Card(
                colors = CardDefaults.cardColors(Color.Transparent),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .height(200.dp)
                    .width(300.dp)
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
            ) {
                SubcomposeAsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = imageMovieUrl(sliderList[page].backdropPath, width = "original"),
                    contentDescription = null,
                    loading = {
                       /* Column(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            CircularProgressIndicator()
                        }*/
                    },
                    contentScale = ContentScale.Crop,
                )
            }
        }
        Row(
            Modifier
                .height(40.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(sliderList.size) { page ->
                val color =
                    if (pagerState.currentPage == page) Color(0xFF12CDD9) else Color(0xFF3fabcf)
                val withButton = if (pagerState.currentPage == page) {
                    38.dp
                } else 10.dp
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .width(withButton)
                        .size(10.dp)
                        .background(color)
                        .clickable {
                            scope.launch {
                                pagerState.animateScrollToPage(page)
                            }
                        }
                )
            }
        }
    }
}

@Composable
fun Categories(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp),
        text = "Categories",
        style = TextStyle(
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.montserrat)),
            color = Color.White
        )
    )
}

@Composable
fun ListMovies(
    navController: NavHostController,
    movieAndSeries: List<MovieAndSeries>,
    title: String
) {

    Box(
        Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                color = Color.White,
            )
        )
    }
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp),
    ) {
        items(movieAndSeries.size) { item ->
            Card(
                modifier = Modifier
                    .width(135.dp)
                    .height(231.dp)
                    .padding(8.dp, 20.dp)
                    .clickable {
                        navController.navigate(route = AppScreen.MovieDetails.route + "/${movieAndSeries[item]._id}/${movieAndSeries[item]._type}")
                    },
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    SubcomposeAsyncImage(
                        model = imageMovieUrl(movieAndSeries[item]._url),
                        contentDescription = null,
                        loading = {
                            Column(
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        },
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}


