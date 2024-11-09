package com.example.cryptowave.crypto.data.networking

import com.example.cryptowave.core.data.networking.constructUrl
import com.example.cryptowave.core.data.networking.safeCall
import com.example.cryptowave.core.domain.util.NetworkError
import com.example.cryptowave.core.domain.util.Result
import com.example.cryptowave.core.domain.util.map
import com.example.cryptowave.crypto.data.networking.dto.CoinsResponseDto
import com.example.cryptowave.crypto.data.networking.mappers.toCoin
import com.example.cryptowave.crypto.domain.Coin
import com.example.cryptowave.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response->
            response.data.map { it.toCoin() }
        }
    }
}