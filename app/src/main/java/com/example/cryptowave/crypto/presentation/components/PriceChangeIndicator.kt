package com.example.cryptowave.crypto.presentation.components

import CryptoWaveTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptowave.crypto.presentation.models.DisplayableValue
import greenBackground

@Composable
fun PriceChangeIndicator(
    modifier: Modifier = Modifier,
    changePercent: DisplayableValue
) {
    val backgroundColor = if(changePercent.value > 0.0) greenBackground else MaterialTheme.colorScheme.errorContainer
    val contentColor = if(changePercent.value > 0.0) Color.Green else MaterialTheme.colorScheme.onErrorContainer

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(100f))
            .background(color = backgroundColor)
            .padding(4.dp)
    ) {
        Icon(
            imageVector = if(changePercent.value > 0.0) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
            contentDescription = null,
            tint = contentColor
        )
        Text(
            text = "${changePercent.formattedValue} %",
            color = contentColor,
            fontSize = 12.sp
        )
    }
}

@PreviewLightDark
@Composable
fun PriceChangeIndicatorPreview() {
    CryptoWaveTheme {
        PriceChangeIndicator(
            changePercent = DisplayableValue(
                value = 3.3,
                formattedValue = "3.3"
            )
        )
    }
}