package org.arexdev.rickmortyapp

import androidx.compose.ui.window.ComposeUIViewController
import org.arexdev.rickmortyapp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }