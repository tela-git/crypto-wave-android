package com.example.cryptowave.crypto.domain

data class Coin(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val priceUsd: Double,
    val changePercent24Hr: Double,
    val marketCapUsd: Double
)


