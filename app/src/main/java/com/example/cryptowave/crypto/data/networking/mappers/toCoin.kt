package com.example.cryptowave.crypto.data.networking.mappers

import com.example.cryptowave.crypto.data.networking.dto.CoinDto
import com.example.cryptowave.crypto.domain.Coin

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        symbol = symbol,
        rank = rank,
        name = name,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr,
        marketCapUsd = marketCapUsd
    )
}