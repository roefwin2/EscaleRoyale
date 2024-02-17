package com.example.escaleroyaletv.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.escaleroyaletv.presenter.components.AppItem
import com.example.escaleroyaletv.presenter.models.EscaleRoyaleApp

@Composable
fun EscaleRoyaleAppSBar(apps: List<EscaleRoyaleApp>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items(apps) { app ->
            AppItem(
                escaleRoyaleApp = app, modifier = Modifier
                    .size(80.dp)
                    .background(
                        MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(8)
                    )
            )
        }
    }
}