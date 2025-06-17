package org.arexdev.rickmortyapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.arexdev.rickmortyapp.domain.model.CharacterModel
import org.arexdev.rickmortyapp.ui.home.tabs.characters.CharacterOfTheDay

@Preview
@Composable
fun Preview() {
    CharacterOfTheDay(
        CharacterModel(
            id = 1,
            name = "Rick Sanchez",
            isAlive = true,
            image = "",
        )
    )
}