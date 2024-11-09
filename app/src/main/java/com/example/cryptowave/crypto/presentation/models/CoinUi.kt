package com.example.cryptowave.crypto.presentation.models

import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import com.example.cryptowave.crypto.domain.Coin
import com.example.cryptowave.core.presentation.util.getDrawableResourceIdBySymbol
import java.util.Locale

data class CoinUi(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val priceUsd: DisplayableValue,
    val changePercent24Hr: DisplayableValue,
    @DrawableRes val iconRes: Int
)

data class DisplayableValue(
    val value: Double,
    val formattedValue: String
)

fun Coin.toCoinUi(): CoinUi {
    return CoinUi(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        priceUsd = priceUsd.toDisplayableValue(),
        changePercent24Hr = changePercent24Hr.toDisplayableValue(),
        iconRes = getDrawableResourceIdBySymbol(symbol)
    )
}

fun Double.toDisplayableValue() : DisplayableValue {
    val formattedValue = NumberFormat.getNumberInstance(Locale.US).apply {
        maximumFractionDigits = 2
        minimumFractionDigits = 2
    }
    return DisplayableValue(
        value = this,
        formattedValue = formattedValue.format(this)
    )
}