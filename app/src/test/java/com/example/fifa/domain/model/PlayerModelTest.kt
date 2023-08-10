package com.example.fifa.domain.model

import com.example.fifa.PlayerTestDataBuilder
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions.*

import org.junit.Test

internal class PlayerModelTest {

    var playerModel = PlayerModel(
        id = 1,
        name = "paco",
        club = 1,
        league = 1,
        age = 1,
        foot = "Right",
        rating = 45,
        rarity = 3,
        position = "cm"
    )

    @Test
    fun basicIsPlayerModel() {
        assertThat(playerModel, instanceOf(PlayerModel::class.java))
        assertThat(playerModel, notNullValue())
    }
    @Test
    fun getId() {
        val player = PlayerTestDataBuilder().withId(3).builder()

        assertThat(player, instanceOf(PlayerModel::class.java))
        assertThat(player.id, `is`(3))
    }

    @Test
    fun getName() {
        val player = PlayerTestDataBuilder().withName("Messi").builder()

        assertThat(player, instanceOf(PlayerModel::class.java))
        assertThat(player.name, `is`("Messi"))
    }

    @Test
    fun getClub() {
        val player = PlayerTestDataBuilder().withClub(5).builder()

        assertThat(player, instanceOf(PlayerModel::class.java))
        assertThat(player.club, `is`(5))
    }

    @Test
    fun getLeague() {
        val player = PlayerTestDataBuilder().withLeague(6).builder()

        assertThat(player, instanceOf(PlayerModel::class.java))
        assertThat(player.league, `is`(6))
    }

    @Test
    fun getAge() {
        val player = PlayerTestDataBuilder().withAge(30).builder()

        assertThat(player, instanceOf(PlayerModel::class.java))
        assertThat(player.age, `is`(30))
    }

    @Test
    fun getPosition() {
        val player = PlayerTestDataBuilder().withPosition("Centrocampista").builder()

        assertThat(player, instanceOf(PlayerModel::class.java))
        assertThat(player.position, `is`("Centrocampista"))
    }

    @Test
    fun getFoot() {
        val player = PlayerTestDataBuilder().withFoot("Right").builder()

        assertThat(player, instanceOf(PlayerModel::class.java))
        assertThat(player.foot, `is`("Right"))
    }

    @Test
    fun getRating() {
        val player = PlayerTestDataBuilder().withRating(60).builder()

        assertThat(player, instanceOf(PlayerModel::class.java))
        assertThat(player.rating, `is`(60))
    }

    @Test
    fun getRarity() {
        val player = PlayerTestDataBuilder().withRarity(8).builder()

        assertThat(player, instanceOf(PlayerModel::class.java))
        assertThat(player.rarity, `is`(8))
    }

}