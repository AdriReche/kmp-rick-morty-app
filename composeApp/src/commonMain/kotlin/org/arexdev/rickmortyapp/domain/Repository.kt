package org.arexdev.rickmortyapp.domain

import org.arexdev.rickmortyapp.domain.model.CharacterModel

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
}