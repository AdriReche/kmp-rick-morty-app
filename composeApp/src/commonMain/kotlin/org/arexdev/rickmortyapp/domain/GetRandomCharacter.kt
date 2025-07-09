package org.arexdev.rickmortyapp.domain

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.arexdev.rickmortyapp.domain.model.CharacterModel
import org.arexdev.rickmortyapp.domain.model.CharacterOfTheDayModel


class GetRandomCharacter(val repository: Repository) {

    suspend operator fun invoke(): CharacterModel {

        val characterOfTheDay = repository.getCharacterDB()
        val selectedDay = getCurrentDayOfTheYear()

        return if (characterOfTheDay != null && characterOfTheDay.selectedDay == selectedDay) {
            characterOfTheDay.characterModel
        } else {
            val result = getRandomCharacter()
            val characterOfTheDayModel = CharacterOfTheDayModel(
                characterModel = result,
                selectedDay = selectedDay
            )
            repository.saveCharacterOfTheDay(characterOfTheDayModel)
            return result
        }
    }

    private suspend fun getRandomCharacter(): CharacterModel {
        val randomId: Int = (1..826).random()
        return repository.getSingleCharacter(randomId.toString())
    }

    private fun getCurrentDayOfTheYear(): String {
        val instant: Instant = Clock.System.now()
        val localTime: LocalDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return "${localTime.dayOfYear}${localTime.year}"
    }
}