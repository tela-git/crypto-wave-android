package com.example.cryptowave.crypto.domain

import com.example.cryptowave.core.domain.util.NetworkError
import com.example.cryptowave.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins() : Result<List<Coin>, NetworkError>
}