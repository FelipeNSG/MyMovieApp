package com.example.mymovieapp.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyTemplate(
    modifier : Modifier = Modifier,
    container: Color,
    topBar: @Composable () -> Unit,
    bottomBar: @Composable () -> Unit,
    body: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        containerColor = container,
        topBar = topBar,
        bottomBar = bottomBar,
        content = body
    )
}