package org.arexdev.rickmortyapp

import android.app.Application
import org.arexdev.rickmortyapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class RickMortyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(Level.INFO)
            androidContext(this@RickMortyApp)
        }
    }
}