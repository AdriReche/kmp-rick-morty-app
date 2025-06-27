package org.arexdev.rickmortyapp.data.remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.arexdev.rickmortyapp.data.remote.response.CharacterResponse
import org.arexdev.rickmortyapp.data.remote.response.CharactersWrapperResponse

class ApiService(private val client: HttpClient) {

    suspend fun getSingleCharacter(id: String): CharacterResponse {
        return client.get("/api/character/$id").body()
    }

    suspend fun getAllCharacters(page: Int): CharactersWrapperResponse {
        return client.get("/api/character") {
            parameter("page", page)
        }.body()
    }

}