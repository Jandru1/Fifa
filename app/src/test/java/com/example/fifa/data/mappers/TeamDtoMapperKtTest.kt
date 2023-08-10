package com.example.fifa.data.mappers

import com.example.fifa.data.local.Model.TeamLocal
import com.example.fifa.data.remote.dto.ItemDto
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions.*

import org.junit.Test

internal class TeamDtoMapperKtTest {

    @Test
    fun toItemModel() {
        val itemDto = ItemDto(
            id = 1,
            name = "name",
            league = 5
        )

        val itemModel = itemDto.toItemModel()

        assertThat(itemModel.league, `is`(5))
    }

    @Test
    fun toItemLocal() {
        val itemDto = ItemDto(
            id = 1,
            name = "name",
            league = 5
        )

        val itemLocal  = itemDto.toItemLocal()

        assertThat(itemLocal.league, `is`(5))
    }

    @Test
    fun testLocalToItemModel() {
        val itemLocal = TeamLocal(
            id = 1,
            name = "name",
            league = 5
        )

        val itemModel  = itemLocal.toItemModel()
        assertThat(itemModel.league, `is`(5))
    }
}