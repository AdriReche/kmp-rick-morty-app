package org.arexdev.rickmortyapp.di

import org.arexdev.rickmortyapp.ui.details.CharacterDetailViewModel
import org.arexdev.rickmortyapp.ui.home.tabs.characters.CharactersViewModel
import org.arexdev.rickmortyapp.ui.home.tabs.episodes.EpisodesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val uiModule = module {
    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharactersViewModel)
    viewModelOf(::CharacterDetailViewModel)
}