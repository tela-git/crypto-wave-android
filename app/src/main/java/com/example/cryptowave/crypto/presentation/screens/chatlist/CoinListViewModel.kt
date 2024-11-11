package com.example.cryptowave.crypto.presentation.screens.chatlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptowave.core.domain.util.onError
import com.example.cryptowave.core.domain.util.onSuccess
import com.example.cryptowave.crypto.domain.CoinDataSource
import com.example.cryptowave.crypto.presentation.models.toCoinUi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoinListViewModel(
    private val coinDataSource: CoinDataSource
): ViewModel() {
    private val _state = MutableStateFlow(CoinListState())
    val state = _state.asStateFlow()
        .onStart { loadCoins() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = CoinListState()
        )

    private val _events = Channel<CoinListEvent>()
    val events = _events.receiveAsFlow()


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
                .onError {e->
                    _state.update { it.copy(isLoading = false) }
                    _events.send(CoinListEvent.Error(e))
                }
        }
    }
}