package org.arexdev.rickmortyapp.data.remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.arexdev.rickmortyapp.data.remote.response.CharacterResponse

class ApiService(private val client: HttpClient) {

    suspend fun getSingleCharacter(id: String): CharacterResponse {
        return client.get("/api/character/$id").body()
    }

}