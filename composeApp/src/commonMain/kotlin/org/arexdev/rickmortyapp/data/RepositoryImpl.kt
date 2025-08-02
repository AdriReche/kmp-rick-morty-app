package org.arexdev.rickmortyapp.data

import app.cash.paging.Pager
import app.cash.paging.PagingConfig
import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.arexdev.rickmortyapp.data.database.RickMortyDatabase
import org.arexdev.rickmortyapp.data.database.entity.CharacterOfTheDayEntity
import org.arexdev.rickmortyapp.data.remote.ApiService
import org.arexdev.rickmortyapp.data.remote.paging.CharactersPagingSource
import org.arexdev.rickmortyapp.data.remote.paging.EpisodesPagingSource
import org.arexdev.rickmortyapp.domain.Repository
import org.arexdev.rickmortyapp.domain.model.CharacterModel
import org.arexdev.rickmortyapp.domain.model.CharacterOfTheDayModel
import org.arexdev.rickmortyapp.domain.model.EpisodeModel

class RepositoryImpl(
    private val apiService: ApiService,
    private val charactersPagingSource: CharactersPagingSource,
    private val episodesPagingSource: EpisodesPagingSource,
    private val rickMortyDatabase: RickMortyDatabase
) : Repository {

    companion object {
        private const val MAX_ITEMS = 20
        private const val PREFETCH_ITEMS = 5
    }

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return apiService.getSingleCharacter(id).toDomainModel()
    }

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS
            ), pagingSourceFactory = { charactersPagingSource }).flow
    }

    override fun getAllEpisodes(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS
            ), pagingSourceFactory = { episodesPagingSource }).flow
    }

    override suspend fun getEpisodesForCharacter(episodes: List<String>): List<EpisodeModel> {
        if (episodes.isEmpty()) return emptyList()

        return if (episodes.size > 1) {
            apiService.getEpisodes(episodes.joinToString(",")).map { episodeResponse ->
                episodeResponse.toDomainModel()
            }
        } else {
            listOf(apiService.getSingleEpisode(episodes.first()).toDomainModel())
        }

    }

    override suspend fun getCharacterDbBySelectedDate(selectedDay: String): CharacterOfTheDayModel? {
        return rickMortyDatabase.getPreferencesDao().getCharacterOfTheDayDb(selectedDay)?.toDomainModel()
    }

    override suspend fun saveCharacterOfTheDay(characterOfTheDayModel: CharacterOfTheDayModel) {
        val characterOfTheDayEntity = CharacterOfTheDayEntity.fromDomainModel(characterOfTheDayModel)
        return rickMortyDatabase.getPreferencesDao().saveCharacterOfTheDayDb(characterOfTheDayEntity)
    }
}
