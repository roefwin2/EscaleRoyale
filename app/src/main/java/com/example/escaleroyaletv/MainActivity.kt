package com.example.escaleroyaletv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.escaleroyaletv.presenter.EscaleRoyaleAppSBar
import com.example.escaleroyaletv.presenter.VideoPlayerScreen
import com.example.escaleroyaletv.presenter.models.EscaleRoyaleApp
import com.example.escaleroyaletv.ui.theme.EscaleRoyaleTVTheme

class MainActivity : ComponentActivity() {
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepVisibleCondition {
                viewModel.isLoading.value
            }
        }
        // Set the video path from the "res/raw" directory
        val videoPath = "android.resource://" + packageName + "/" + R.raw.escale_royale_video

        setContent {
            EscaleRoyaleTVTheme {
                EscaleRoyaleScreen(
                    videoPath
                )
            }
        }
    }
}

@Composable
fun EscaleRoyaleScreen(videoPath: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        VideoPlayerScreen(videoPath = videoPath)
        EscaleRoyaleAppSBar(
            apps = listOf(
                EscaleRoyaleApp(
                    R.drawable.icon_netflix,
                    "http://www.netflix.com/home"
                ),
                EscaleRoyaleApp(
                    R.drawable.tiktok_new_version_bis,
                    "https://play.google.com/store/apps/details?id=com.tiktok.tv&pcampaignid=web_share"
                ),
                EscaleRoyaleApp(
                    R.drawable.instagram_logo_transparent_background,
                    "https://play.google.com/store/apps/details?id=com.instagram.android&pcampaignid=web_share"
                ),
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EscaleRoyaleScreenPreview() {
    EscaleRoyaleTVTheme {
        EscaleRoyaleScreen("")
    }
}