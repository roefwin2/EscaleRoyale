package com.example.escaleroyaletv.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Button
import androidx.tv.material3.Card
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.OutlinedButton
import androidx.tv.material3.Text
import com.example.escaleroyaletv.ui.theme.EscaleRoyaleTVTheme


@Composable
fun HotelFidelityProgram(modifier: Modifier = Modifier, onBtnClick: (() -> Unit)) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 32.dp)
    ) {
        Text(
            text = "Programme de fidélité",
            color = MaterialTheme.colorScheme.onTertiaryContainer,
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        FidelityLevelCard(
            description = "20% de réduction sur les réservations, surclassement gratuit"
        ) {
            onBtnClick.invoke()
        }

    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun FidelityLevelCard(description: String, onBtnClick: (() -> Unit)) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {
            onBtnClick.invoke()
        },
        colors = CardDefaults.colors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = description,
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun HotelFidelityProgramScreenPreview() {
    EscaleRoyaleTVTheme {
        HotelFidelityProgram() {}
    }
}