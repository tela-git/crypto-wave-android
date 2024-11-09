package com.example.cryptowave.core.domain.util

enum class NetworkError: Error {
    NO_INTERNET,
    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    SERIALIZATION_ERROR,
    SERVER_ERROR,
    UNKNOWN_ERROR
}