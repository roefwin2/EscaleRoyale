package com.example.escaleroyaletv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.OutlinedButton
import androidx.tv.material3.Text
import com.example.escaleroyaletv.presenter.EscaleRoyaleAppSBar
import com.example.escaleroyaletv.presenter.VideoPlayerScreen
import com.example.escaleroyaletv.presenter.components.HotelFidelityProgram
import com.example.escaleroyaletv.presenter.models.EscaleRoyaleApp
import com.example.escaleroyaletv.ui.theme.EscaleRoyaleTVTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the video path from the "res/raw" directory
        val videoPath = "android.resource://" + packageName + "/" + R.raw.escale_royale_video

        setContent {
            EscaleRoyaleTVTheme {
                EscaleRoyaleScreen(videoPath)
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun EscaleRoyaleScreen(videoPath: String, modifier: Modifier = Modifier) {
    var isProgrammFidReveal by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        VideoPlayerScreen(videoPath = videoPath)
        EscaleRoyaleAppSBar(
            apps = listOf(
                EscaleRoyaleApp(
                    R.drawable.icon_netflix,
                    "http://www.netflix.com/watch"
                ),
                EscaleRoyaleApp(
                    R.drawable.tiktok_new_version_bis,
                    "http://www.youtube.com/watch?v=xxxx"
                ),
                EscaleRoyaleApp(
                    R.drawable.instagram_logo_transparent_background,
                    "http://instagram.com"
                ),
            )
        )
        AnimatedVisibility(visible = !isProgrammFidReveal) {
            OutlinedButton(onClick = {
                isProgrammFidReveal = true
            }) {
                Text(text = "Découvrir le Programme Fidélité")
            }
        }
        AnimatedVisibility(visible = isProgrammFidReveal) {
            HotelFidelityProgram() {
                isProgrammFidReveal = false
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EscaleRoyaleScreenPreview() {
    EscaleRoyaleTVTheme {
        EscaleRoyaleScreen("")
    }
}