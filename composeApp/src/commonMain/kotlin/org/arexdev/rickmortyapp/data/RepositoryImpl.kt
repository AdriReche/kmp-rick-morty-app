package org.arexdev.rickmortyapp.data

import org.arexdev.rickmortyapp.data.remote.ApiService
import org.arexdev.rickmortyapp.domain.Repository
import org.arexdev.rickmortyapp.domain.model.CharacterModel

class RepositoryImpl(private val apiService: ApiService) : Repository {
    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return apiService.getSingleCharacter(id).toDomainModel()
    }
}
