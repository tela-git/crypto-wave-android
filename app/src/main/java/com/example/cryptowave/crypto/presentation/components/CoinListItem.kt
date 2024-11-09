package com.example.cryptowave.crypto.presentation.components

import CryptoWaveTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptowave.crypto.domain.Coin
import com.example.cryptowave.crypto.presentation.models.CoinUi
import com.example.cryptowave.crypto.presentation.models.toCoinUi

@Composable
fun CoinListItem(
    coinUI: CoinUi,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val contentColor = if(isSystemInDarkTheme()) Color.White else Color.Black
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(16.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(coinUI.iconRes),
            contentDescription = coinUI.name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .size(85.dp)
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = coinUI.symbol,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = contentColor
            )
            Text(
                text = coinUI.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                color = contentColor
            )
        }
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "$${coinUI.priceUsd.formattedValue}",
                color = contentColor,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
            Spacer(Modifier.height(8.dp))
            PriceChangeIndicator(
                changePercent = coinUI.changePercent24Hr
            )
        }
    }

}

@PreviewLightDark
@Composable
fun CoinListItemPreview() {
    CryptoWaveTheme {
        CoinListItem(
            coinUI = bitcoin,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background),
            onClick = { }

        )
    }
}

val bitcoin = Coin(
    id = "bitcoin",
    symbol = "BTC",
    name = "Bitcoin",
    rank = 1,
    priceUsd = 2343434.232,
    changePercent24Hr = 3.94,
).toCoinUi()