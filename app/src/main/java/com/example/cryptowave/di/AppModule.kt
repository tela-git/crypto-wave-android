package com.example.cryptowave.di

import com.example.cryptowave.core.data.networking.HttpClientFactory
import com.example.cryptowave.crypto.data.networking.RemoteCoinDataSource
import com.example.cryptowave.crypto.domain.CoinDataSource
import com.example.cryptowave.crypto.presentation.screens.chatlist.CoinListViewModel
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}