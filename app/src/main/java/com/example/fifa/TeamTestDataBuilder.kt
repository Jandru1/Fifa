package com.example.fifa

import com.example.fifa.domain.model.ItemModel

class TeamTestDataBuilder {
    var id: Int = -1
    var name: String = "name"
    var league: Int = -1

    fun withId(id: Int) :TeamTestDataBuilder {
        this.id = id
        return this
    }

    fun withName(name: String):TeamTestDataBuilder {
        this.name = name
        return this
    }

    fun withLeague(league: Int) :TeamTestDataBuilder{
        this.league = league
        return this
    }

    fun builder(): ItemModel = ItemModel(
        id = id,
        name = name,
        league = league
    )
}
