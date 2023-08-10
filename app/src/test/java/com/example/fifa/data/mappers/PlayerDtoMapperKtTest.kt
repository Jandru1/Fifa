package com.example.fifa.data.mappers

import com.example.fifa.data.local.Model.PlayerLocal
import com.example.fifa.data.mappers.toPlayerLocal
import com.example.fifa.data.mappers.toPlayerModel
import com.example.fifa.data.remote.dto.PlayerDto
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

internal class PlayerDtoMapperKtTest {

    @Test
    fun toPlayerModel() {
        val playerDto = PlayerDto(
            id = 1,
            name = "Pepe",
            club = 3,
            league = 5,
            foot = "Right",
            position = "cm",
            rarity = 3,
            rating = 89,
            age = 34
        )

        val playerModel = playerDto.toPlayerModel()

        assertThat(playerModel.id, `is`(1))
    }

    @Test
    fun toPlayerLocal() {
        val playerDto = PlayerDto(
            id = 1,
            name = "Pepe",
            club = 3,
            league = 5,
            foot = "Right",
            position = "cm",
            rarity = 3,
            rating = 89,
            age = 34
        )

        val playerLocal = playerDto.toPlayerLocal()

        assertThat(playerLocal.id, `is`(1))
    }

    @Test
    fun testLocalToPlayerModel() {
        val playerLocal = PlayerLocal(
            id = 1,
            name = "Pepe",
            club = 3,
            league = 5,
            foot = "Right",
            position = "cm",
            rarity = 3,
            rating = 89,
            age = 34
        )

        val playerModel = playerLocal.toPlayerModel()

        assertThat(playerModel.id, `is`(1))
    }
}