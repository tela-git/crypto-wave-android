package com.example.cryptowave.crypto.presentation.screens.chatlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptowave.core.domain.util.onError
import com.example.cryptowave.core.domain.util.onSuccess
import com.example.cryptowave.crypto.domain.CoinDataSource
import com.example.cryptowave.crypto.presentation.models.toCoinUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoinListViewModel(
    private val coinDataSource: CoinDataSource
): ViewModel() {
    private val _state = MutableStateFlow(CoinListState())
    val state = _state
        .onStart { loadCoins() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = CoinListState()
        )

    private fun loadCoins() {
        _state.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            coinDataSource
                .getCoins()
                .onSuccess { coins->
                    _state.update { it.copy(
                        isLoading = false,
                        coinList = coins.map { it.toCoinUi() }
                    ) }
                }
                .onError {
                    _state.update { it.copy(isLoading = false) }
                }
        }
    }
}