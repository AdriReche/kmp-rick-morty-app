package org.arexdev.rickmortyapp.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration


expect fun platformModule(): Module
fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            dataModule,
            domainModule,
            uiModule,
            platformModule(),
        )
    }
}