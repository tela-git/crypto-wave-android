package com.example.cryptowave.crypto.presentation.screens.chatlist

import com.example.cryptowave.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}