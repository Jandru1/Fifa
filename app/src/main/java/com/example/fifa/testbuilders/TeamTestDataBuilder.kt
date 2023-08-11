package com.example.fifa.testbuilders

import com.example.fifa.domain.model.TeamModel

class TeamTestDataBuilder {
    var id: Int = -1
    var name: String = "name"
    var league: Int = -1

    var numElements: Int = 1

    fun withId(id: Int) : TeamTestDataBuilder {
        this.id = id
        return this
    }

    fun withName(name: String): TeamTestDataBuilder {
        this.name = name
        return this
    }

    fun withLeague(league: Int) : TeamTestDataBuilder {
        this.league = league
        return this
    }
    fun withNumElements(el: Int) : TeamTestDataBuilder {
        this.numElements = el
        return this
    }

    fun buildList(): List<TeamModel> {
        val list = mutableListOf<TeamModel>()

        for(i in 0 until numElements) {
            list.add(
                TeamModel(
                    id = id,
                    name = name,
                    league = league
                )
            )
        }
        return list.toList()
    }

    fun builder(): TeamModel = TeamModel(
        id = id,
        name = name,
        league = league
    )
}
