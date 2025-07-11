package org.arexdev.rickmortyapp.domain

import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.arexdev.rickmortyapp.domain.model.CharacterModel
import org.arexdev.rickmortyapp.domain.model.CharacterOfTheDayModel
import org.arexdev.rickmortyapp.domain.model.EpisodeModel

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
    suspend fun getCharacterDbBySelectedDate(selectedDay : String): CharacterOfTheDayModel?
    suspend fun saveCharacterOfTheDay(characterOfTheDayModel: CharacterOfTheDayModel)
    fun getAllEpisodes(): Flow<PagingData<EpisodeModel>>
}
