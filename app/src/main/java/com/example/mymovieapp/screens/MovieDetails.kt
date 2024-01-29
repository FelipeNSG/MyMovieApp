package com.example.mymovieapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mymovieapp.common.BodyTemplate
import com.example.mymovieapp.common.TopAppBarTemplate
import com.example.mymovieapp.navigation.AppScreen
import com.example.mymovieapp.ui.theme.colorWhite
import com.example.mymovieapp.ui.theme.containerColor

@Composable
fun Details(navController: NavHostController, title: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(containerColor)
            .clickable {
                navController.navigate(route = AppScreen.Home.route)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (title.isNullOrEmpty()) {
            Text(text = "")
        } else {
            Text(text = title, color = colorWhite)
        }
    }
}

@Composable
fun MovieDetails(navController: NavHostController, title: String?) {

        BodyTemplate(

            container = containerColor,
            topBar = { TopAppBarTemplate(title = title, secondIcon = true) },
            bottomBar = { },
            body = { Details(navController, title) }
        )

}