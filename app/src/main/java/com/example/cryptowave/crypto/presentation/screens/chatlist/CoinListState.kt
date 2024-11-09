package com.example.cryptowave.crypto.presentation.screens.chatlist

import androidx.compose.runtime.Immutable
import com.example.cryptowave.crypto.presentation.models.CoinUi

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coinList: List<CoinUi> = emptyList()
)
