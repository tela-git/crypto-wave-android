package com.example.cryptowave.core.data.networking

import com.example.cryptowave.BuildConfig

fun constructUrl(url: String): String {
    val baseUrl = BuildConfig.BASE_URL
    return when {
        url.contains(baseUrl) -> {
            url
        }
        url.startsWith("/") -> {
            baseUrl + url.drop(1)
        }
        else -> {
            baseUrl + url
        }
    }
}