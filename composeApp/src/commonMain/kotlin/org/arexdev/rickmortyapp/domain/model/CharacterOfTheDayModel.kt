package org.arexdev.rickmortyapp.domain.model


data class CharacterOfTheDayModel(
    val characterModel: CharacterModel,
    val selectedDay: String
)