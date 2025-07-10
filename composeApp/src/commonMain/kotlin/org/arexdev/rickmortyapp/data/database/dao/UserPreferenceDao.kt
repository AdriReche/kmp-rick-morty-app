package org.arexdev.rickmortyapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.arexdev.rickmortyapp.data.database.entity.CharacterOfTheDayEntity

@Dao
interface UserPreferenceDao {

    @Query("SELECT * FROM character_of_the_day WHERE selectedDay = :selectedDay")
    suspend fun getCharacterOfTheDayDb(selectedDay: String): CharacterOfTheDayEntity?

    @Insert(entity = CharacterOfTheDayEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacterOfTheDayDb(entity: CharacterOfTheDayEntity)
}