package com.example.escaleroyaletv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.escaleroyaletv.presenter.EscaleRoyaleAppSBar
import com.example.escaleroyaletv.presenter.VideoPlayerScreen
import com.example.escaleroyaletv.presenter.models.EscaleRoyaleApp
import com.example.escaleroyaletv.ui.theme.EscaleRoyaleTVTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepVisibleCondition {
                viewModel.isLoading.value
            }
        }
        // Set the video path from the "res/raw" directory
        val videoPath =
            "android.resource://" + packageName + "/" + R.raw.escale_royale_video_high_quality

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
            .fillMaxSize()
    ) {
        VideoPlayerScreen(videoPath = videoPath)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp)
                .align(Alignment.TopCenter),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.escale_royale_logo_white),
                    modifier = Modifier
                        .size(250.dp),
                    contentDescription = null
                )
                EscaleRoyaleAppSBar(
                    apps = listOf(
                        EscaleRoyaleApp(
                            R.drawable.icon_netflix,
                            "http://www.netflix.com/home"
                        ),
                        EscaleRoyaleApp(
                            R.drawable.france_tv_icon,
                            "https://play.google.com/store/apps/details?id=fr.francetv.pluzz&pcampaignid=web_share"
                        ),
                        EscaleRoyaleApp(
                            R.drawable.tiktok_new_version_bis,
                            "https://play.google.com/store/apps/details?id=com.tiktok.tv&pcampaignid=web_share"
                        ),
                        EscaleRoyaleApp(
                            R.drawable.instagram_logo_transparent_background,
                            "https://play.google.com/store/apps/details?id=com.instagram.android&pcampaignid=web_share"
                        ),
                        EscaleRoyaleApp(
                            R.drawable.youtube_icon,
                            "https://www.youtube.com/watch"
                        ),
                    )
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
            ) {
                BlackBandWithTextAndQRCode()
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