package com.example.mymovieapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.mymovieapp.ui.theme.containerColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTemplate(
    container: Color,
    topBar: @Composable ()->Unit,
    bottomBar: @Composable ()-> Unit,
    body: @Composable ()-> Unit
){
    Scaffold(
        containerColor = container,
        topBar = topBar,
        bottomBar = bottomBar,
        content = {_-> body}

    )
    }

@Composable
fun MovieDetails(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
            Text(text = "Hola", color = Color.White)
    }
}

@Composable
fun ScaffoldTemplatePreview(){
    ScaffoldTemplate(
        container = containerColor,
        topBar = { },
        bottomBar = { BottomBar()},
        body = { MovieDetails()}
    )
}