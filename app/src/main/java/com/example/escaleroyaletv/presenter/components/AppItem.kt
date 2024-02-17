package com.example.escaleroyaletv.presenter.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.core.content.ContextCompat
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.example.escaleroyaletv.presenter.models.EscaleRoyaleApp

@Composable
fun AppItem(escaleRoyaleApp: EscaleRoyaleApp, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Image(painter = painterResource(id = escaleRoyaleApp.iconId), modifier = modifier
        .clickable {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = Uri.parse(escaleRoyaleApp.pathUrl)
            intent.putExtra("source", "30") // careful: String, not int
            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            ContextCompat.startActivity(context, intent, null)
        }, contentDescription = "icons"
    )
}
