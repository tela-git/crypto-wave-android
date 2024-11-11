package com.example.cryptowave

import CryptoWaveTheme
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cryptowave.core.presentation.util.ObserveAsEvents
import com.example.cryptowave.core.presentation.util.toString
import com.example.cryptowave.crypto.presentation.screens.chatlist.CoinListEvent
import com.example.cryptowave.crypto.presentation.screens.chatlist.CoinListScreen
import com.example.cryptowave.crypto.presentation.screens.chatlist.CoinListViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoWaveTheme {
                val coinListViewModel = koinViewModel<CoinListViewModel>()
                val coinListState by coinListViewModel.state.collectAsStateWithLifecycle()
                val context = LocalContext.current

                ObserveAsEvents(events = coinListViewModel.events) { event ->
                    when(event) {
                        is CoinListEvent.Error -> {
                            Toast.makeText(
                                context,
                                event.error.toString(context),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }

                Scaffold { innerPadding->
                    CoinListScreen(
                        coinListState = coinListState,
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}
