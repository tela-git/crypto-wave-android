package com.example.cryptowave.crypto.presentation.screens.chatlist

import CryptoWaveTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.cryptowave.crypto.presentation.components.CoinListItem
import com.example.cryptowave.crypto.presentation.components.bitcoin

@Composable
fun ChatListScreen(
    coinListState: CoinListState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = coinListState.coinList
        ) { coinUi ->
            CoinListItem(
                coinUI = coinUi,
                modifier = modifier.fillMaxWidth(),
                onClick = { }
            )
            HorizontalDivider()
        }
    }
}

@PreviewLightDark
@Composable
fun ChatListScreenPreview() {
    CryptoWaveTheme {
        ChatListScreen(
            coinListState = CoinListState(
                isLoading = false,
                coinList = (1..100).map {
                    bitcoin.copy(
                        id = it.toString()
                    )
                }
            ),
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}