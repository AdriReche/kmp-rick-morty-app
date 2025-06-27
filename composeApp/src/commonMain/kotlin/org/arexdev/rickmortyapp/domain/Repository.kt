package org.arexdev.rickmortyapp.domain

import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.arexdev.rickmortyapp.domain.model.CharacterModel

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel


    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
}