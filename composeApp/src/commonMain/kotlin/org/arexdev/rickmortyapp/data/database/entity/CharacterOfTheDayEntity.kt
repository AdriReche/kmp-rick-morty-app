package org.arexdev.rickmortyapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.arexdev.rickmortyapp.domain.model.CharacterModel
import org.arexdev.rickmortyapp.domain.model.CharacterOfTheDayModel

@Entity(tableName = "character_of_the_day")
data class CharacterOfTheDayEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val isAlive: Boolean,
    val image: String,
    val selectedDay: String
) {
    fun toDomainModel(): CharacterOfTheDayModel {
        return CharacterOfTheDayModel(
            characterModel = CharacterModel(
                id = id,
                name = name,
                isAlive = isAlive,
                image = image
            ),
            selectedDay = selectedDay
        )
    }

    companion object {
        fun fromDomainModel(model: CharacterOfTheDayModel): CharacterOfTheDayEntity {
            return CharacterOfTheDayEntity(
                id = model.characterModel.id,
                name = model.characterModel.name,
                isAlive = model.characterModel.isAlive,
                image = model.characterModel.image,
                selectedDay = model.selectedDay
            )
        }
    }
}

