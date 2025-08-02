package org.arexdev.rickmortyapp.data.remote.response

import kotlinx.serialization.Serializable
import org.arexdev.rickmortyapp.domain.model.CharacterModel

@Serializable
data class CharacterResponse(
    val id: Int,
    val name: String,
    val status: String,
    val image: String,
    val species: String,
    val gender: String,
    val origin: OriginResponse,
    val episode: List<String>,
) {
    fun toDomainModel(): CharacterModel {
        return CharacterModel(
            id = id,
            name = name,
            isAlive = status.lowercase() == "alive",
            image = image,
            species = species,
            gender = gender,
            origin = origin.name,
            episodes = episode.map { episode -> episode.substringAfterLast("/") }
        )
    }
}