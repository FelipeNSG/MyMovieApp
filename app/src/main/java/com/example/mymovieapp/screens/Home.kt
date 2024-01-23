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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.example.mymovieapp.R
import com.example.mymovieapp.clases.BarItem
import com.example.mymovieapp.data.repository.MoviesRepository
import com.example.mymovieapp.movies.Movie
import com.example.mymovieapp.movies.imagenMovieUrl
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

//TODO("MOVE COLORS TO COLOR FILE")
val containerColor = Color(0xFF1F1D2B)
val colorBlue = Color(0xFF12CDD9)
val colorGray = Color(0xFF92929D)

//TODO("REMOVE IF NOT NEEDED")
val scope = CoroutineScope(Dispatchers.Default)


//TODO("REMOVE UNECESARY PREVIEWS)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MediaScreen() {

    Scaffold(
        containerColor = containerColor,
        topBar = {
            TopAppBarMedia()
        },
        bottomBar = { BottomBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            ListUpcomingMovies()
            Categories()
            ListPopularMovies()
            ListPlaynOW()
            MovieListTopRate()
            PopularSeries()
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarMedia(modifier: Modifier = Modifier) {
    var text by rememberSaveable { mutableStateOf("") }
    TopAppBar(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 5.dp),
        title = {
            OutlinedTextField(
                modifier = Modifier
                    .width(320.dp)
                    .height(50.dp),
                value = text,
                onValueChange = {
                    text = it
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.app_bar_placeholder),
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.White),
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Icon",
                            tint = colorGray
                        )
                    }
                },
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.filter),
                            contentDescription = "Icon",
                            tint = Color(0xFF92929D)
                        )
                    }
                },
                textStyle = MaterialTheme.typography.bodyMedium,
                shape = CircleShape,
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor),

        )
}

@Composable
fun ContentBody() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()

    ) {
        items(10) {
            Text(text = "Item $it", color = Color.White)
        }

    }
}

@Composable
fun ListUpcomingMovies() {
    var movieListState by remember {
        mutableStateOf(emptyList<Movie>())
    }
    LaunchedEffect(Unit) {
        movieListState = MoviesRepository.getUpcomingMovies()
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentAlignment = Alignment.Center
    ) {
        if (movieListState.isNotEmpty()) Carousel(sliderList = movieListState.take(5)) else CircularProgressIndicator()
    }
}

@Composable
fun ListPlaynOW() {
    var movieListState by remember {
        mutableStateOf(emptyList<Movie>())
    }
    LaunchedEffect(Unit) {
        movieListState = MoviesRepository.getPlayNow()
    }
    ListMovies(movieList = movieListState, title = "Play Now")
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Carousel(sliderList: List<Movie>) {

    val scope = rememberCoroutineScope()
    var pagerState = rememberPagerState(initialPage = 2)
    Column(

    ) {
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
                AsyncImage(
                    placeholder = painterResource(id = R.drawable.baseline_image_24),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imagenMovieUrl(sliderList[page].backdropPath))
                        .crossfade(true)
                        .scale(Scale.FILL)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    onLoading = {

                    },
                    error = null,
                )
            }
        }

        Row(
            Modifier
                .height(50.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {


            repeat(sliderList.size) { it ->
                val color =
                    if (pagerState.currentPage == it) Color(0xFF12CDD9) else Color(0xFF3fabcf)
                val withButton = if (pagerState.currentPage == it) {
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
                                pagerState.animateScrollToPage(it)
                            }
                        }
                )
            }
        }
    }


}


@Composable
@Preview
fun Categories(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .padding(
                horizontal = 16.dp,
            )
            .padding(bottom = 16.dp),
        text = "Categories",

        // H4/Semibold
        style = TextStyle(
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.montserrat)),
            color = Color(0xFFFFFFFF),
        )
    )

}

@Composable
fun PopularSeries() {
    var movieListState by remember {
        mutableStateOf(emptyList<Movie>())
    }
    LaunchedEffect(Unit) {
        movieListState = MoviesRepository.getPopularSeries()
    }
    ListMovies(movieList = movieListState, "Popular Series")
}

@Composable
fun MovieListTopRate() {
    var movieListState by remember {
        mutableStateOf(emptyList<Movie>())
    }
    LaunchedEffect(Unit) {
        movieListState = MoviesRepository.getTopRate()
    }
    ListMovies(movieList = movieListState, "Top rate")

}

@Composable
fun ListPopularMovies() {
    var movieListState by remember {
        mutableStateOf(emptyList<Movie>())
    }
    LaunchedEffect(Unit) {
        movieListState = MoviesRepository.getPopularMovies()
    }
    ListMovies(movieList = movieListState, "Most Populars")

}

@Composable
fun ListMovies(movieList: List<Movie>, title: String) {

    Box(
        Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = title,

            // H4/Semibold
            style = TextStyle(
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                color = Color(0xFFFFFFFF),

                )
        )
    }
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 8.dp
            ),
    ) {
        items(movieList.size) { item ->
            Card(
                modifier = Modifier
                    .width(135.dp)
                    .height(231.dp)
                    .padding(8.dp, 20.dp),

                ) {
                SubcomposeAsyncImage(
                    model = imagenMovieUrl(movieList[item].url),
                    contentDescription = null,
                    loading = { CircularProgressIndicator(color = Color.White) },
                    contentScale = ContentScale.Crop,

                    )
            }
        }
    }
}

@Composable
fun BottomBar(modifier: Modifier = Modifier) {

    var selectedItem by remember { mutableIntStateOf(0) }
    var barItems = listOf<BarItem>(
        BarItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = "Home"
        ),
        BarItem(
            title = "Search",
            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search,
            route = "Search"
        ),
        BarItem(
            title = "Download",
            selectedIcon = Icons.Filled.Download,
            unselectedIcon = Icons.Outlined.Download,
            route = "Home"
        ),
        BarItem(
            title = "Home",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            route = "Home"
        )
    )
    NavigationBar(
        containerColor = containerColor,
    ) {
        barItems.forEachIndexed { index, barItem ->
            val selected = selectedItem == index
            NavigationBarItem(
                selected = selected,
                onClick = { selectedItem = index },
                icon = {
                    Icon(
                        imageVector = if (selected) barItem.selectedIcon else barItem.unselectedIcon,
                        contentDescription = barItem.title,
                        tint = if (selected) colorBlue else colorGray
                    )
                },
                label = {
                    Text(
                        text = barItem.title,
                        color = if (selected) colorBlue else colorGray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xFF252836)
                )
            )

        }

    }


}
