package org.arexdev.rickmortyapp.ui.home.tabs.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.cash.paging.cachedIn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.arexdev.rickmortyapp.domain.Repository

class EpisodesViewModel(private val repository: Repository) : ViewModel() {
    private val _state = MutableStateFlow<EpisodesState>(EpisodesState())
    val state: StateFlow<EpisodesState> = _state

    init {
        _state.update { state -> state.copy(episodes = repository.getAllEpisodes().cachedIn(viewModelScope)) }
    }

    fun onPlaySelected(url: String) {
        _state.update { state -> state.copy(playVideo = url) }
    }

    fun onCloseVideo() {
        _state.update { state -> state.copy(playVideo = "") }
    }
}