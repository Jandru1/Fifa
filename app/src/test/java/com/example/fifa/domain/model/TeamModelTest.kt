package com.example.fifa.domain.model

import com.example.fifa.testbuilders.TeamTestDataBuilder
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat

import org.junit.Test

internal class TeamModelTest {

    val myTeam = TeamModel(
        id = 4,
        name = "Bundes",
        league= 40
    )

    @Test
    fun basicTeamTest(){
        assertThat(myTeam, instanceOf(TeamModel::class.java))
        assertThat(myTeam, notNullValue())
    }
    @Test
    fun getId() {
        val team = TeamTestDataBuilder().withId(1).builder()

        assertThat(team, instanceOf(TeamModel::class.java))
        assertThat(team.id, `is`(1))
    }

    @Test
    fun getName() {
        val team = TeamTestDataBuilder().withName("Madrid").builder()

        assertThat(team, instanceOf(TeamModel::class.java))
        assertThat(team.name, `is`("Madrid"))
    }

    @Test
    fun getLeague() {
        val team = TeamTestDataBuilder().withLeague(10).builder()

        assertThat(team, instanceOf(TeamModel::class.java))
        assertThat(team.league, `is`(10))
    }
}