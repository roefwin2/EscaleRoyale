package com.example.escaleroyaletv

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Text
import com.example.escaleroyaletv.ui.theme.EscaleRoyaleTVTheme

@Composable
fun BlackBandWithTextAndQRCode(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(0.8f)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Black.copy(alpha = 0.5f))
            .height(80.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Gagnez un séjour offert grâce à notre jeu concours",
            color = Color.White,
            fontSize = 28.sp,
            maxLines = 1,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,

            )

        Image(
            painter = painterResource(id = R.drawable.escale_royale_qr_code),
            modifier = Modifier
                .size(200.dp)
                .padding(start = 24.dp),
            contentDescription = "qrcode"
        )
    }
}

@Preview
@Composable
fun PreviewBlackBandWithTextAndQRCode() {
    EscaleRoyaleTVTheme {
        BlackBandWithTextAndQRCode()
    }
}
