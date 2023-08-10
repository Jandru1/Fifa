package com.example.fifa.data.mappers

import com.example.fifa.data.local.Model.TeamLocal
import com.example.fifa.data.remote.dto.TeamDto
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

import org.junit.Test

internal class TeamDtoMapperKtTest {

    @Test
    fun toItemModel() {
        val teamDto = TeamDto(
            id = 1,
            name = "name",
            league = 5
        )

        val itemModel = teamDto.toItemModel()

        assertThat(itemModel.league, `is`(5))
    }

    @Test
    fun toItemLocal() {
        val teamDto = TeamDto(
            id = 1,
            name = "name",
            league = 5
        )

        val itemLocal  = teamDto.toItemLocal()

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