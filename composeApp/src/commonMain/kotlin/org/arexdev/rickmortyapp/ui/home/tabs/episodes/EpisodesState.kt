package org.arexdev.rickmortyapp.ui.home.tabs.episodes

import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.arexdev.rickmortyapp.domain.model.EpisodeModel

data class EpisodesState(val episodes: Flow<PagingData<EpisodeModel>> = emptyFlow())