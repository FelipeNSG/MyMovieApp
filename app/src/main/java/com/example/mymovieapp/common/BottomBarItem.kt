package com.example.mymovieapp.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.mymovieapp.clases.BarItem
import com.example.mymovieapp.ui.theme.colorBlue
import com.example.mymovieapp.ui.theme.colorGray
import com.example.mymovieapp.ui.theme.colorLightBlack
import com.example.mymovieapp.ui.theme.containerColor

@Composable
fun BottomBar() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val barItems = listOf(
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
            route = "Download"
        ),
        BarItem(
            title = "Favorites",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
            route = "Favorites"
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
                    indicatorColor = colorLightBlack
                )
            )
        }
    }
}