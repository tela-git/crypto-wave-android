package com.example.cryptowave

import android.app.Application
import com.example.cryptowave.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin

class CryptoWaveApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CryptoWaveApplication)
            androidLogger()

            modules(appModule)
        }
    }
}