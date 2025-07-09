package org.arexdev.rickmortyapp.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import org.arexdev.rickmortyapp.data.database.dao.UserPreferenceDao
import org.arexdev.rickmortyapp.data.database.entity.CharacterOfTheDayEntity

const val DATABASE_NAME = "rm_app_database.db"

expect object RickMortyCtor : RoomDatabaseConstructor<RickMortyDatabase>

@Database(entities = [CharacterOfTheDayEntity::class], version = 1)
@ConstructedBy(RickMortyCtor::class)
abstract class RickMortyDatabase : RoomDatabase() {
    abstract fun getPreferencesDao(): UserPreferenceDao
}