package org.arexdev.rickmortyapp.di

import org.arexdev.rickmortyapp.data.database.RickMortyDatabase
import org.arexdev.rickmortyapp.data.database.getDataBase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single<RickMortyDatabase> { getDataBase() }
    }
}