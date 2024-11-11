package com.example.cryptowave.crypto.presentation.screens.chatlist

import CryptoWaveTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.cryptowave.crypto.presentation.components.CoinListItem
import com.example.cryptowave.crypto.presentation.components.bitcoin
import kotlinx.coroutines.flow.MutableSharedFlow

@Composable
fun CoinListScreen(
    coinListState: CoinListState,
    modifier: Modifier = Modifier
) {
    if(coinListState.isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    else {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(12.dp)
        ) {
            items(
                items = coinListState.coinList
            ) { coinUi ->
                CoinListItem(
                    coinUI = coinUi,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {}
                )
                HorizontalDivider()
            }
        }
    }
}

@PreviewLightDark
@Composable
fun ChatListScreenPreview() {
    CryptoWaveTheme {
        CoinListScreen(
            coinListState = CoinListState(
                isLoading = false,
                coinList = (1..100).map {
                    bitcoin.copy(
                        id = it.toString()
                    )
                }
            ),
            modifier = Modifier.background(MaterialTheme.colorScheme.background),

        )
    }
}