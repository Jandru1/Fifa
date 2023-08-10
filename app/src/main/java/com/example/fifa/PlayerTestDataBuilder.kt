package com.example.fifa

import com.example.fifa.domain.model.PlayerModel
import com.example.fifa.domain.model.TeamModel

class PlayerTestDataBuilder {
    var id: Int = -1
    var commonName: String = "commonName"
    var club: Int = -1
    var league: Int = -1
    var age: Int = -1
    var position: String = "none"
    var foot: String = "none"
    var rating: Int = -1
    var rarity: Int = -1

    var numElements = -1

    fun withId(id: Int) :PlayerTestDataBuilder {
        this.id = id
        return this
    }

    fun withName(commonName: String):PlayerTestDataBuilder {
        this.commonName = commonName
        return this
    }

    fun withClub(club: Int) :PlayerTestDataBuilder{
        this.club = club
        return this
    }
    fun withLeague(league: Int) :PlayerTestDataBuilder{
        this.league = league
        return this
    }
    fun withAge(age: Int) :PlayerTestDataBuilder{
        this.age = age
        return this
    }

    fun withPosition(pos: String) :PlayerTestDataBuilder{
        this.position = pos
        return this
    }
    fun withFoot(foot: String) :PlayerTestDataBuilder{
        this.foot = foot
        return this
    }

    fun withRating(rating: Int) :PlayerTestDataBuilder{
        this.rating = rating
        return this
    }
    fun withRarity(rarity: Int) :PlayerTestDataBuilder{
        this.rarity = rarity
        return this
    }

    fun withNumElements(el: Int) :PlayerTestDataBuilder{
        this.numElements = el
        return this
    }

    fun buildList(): List<PlayerModel> {
        val list = mutableListOf<PlayerModel>()

        for(i in 0 until numElements) {
            list.add(
                PlayerModel(
                    id = id,
                    name = commonName,
                    club = club,
                    league = league,
                    foot = foot,
                    position = position,
                    age = age,
                    rarity = rarity,
                    rating = rating
                )
            )
        }
        return list.toList()
    }

    fun builder(): PlayerModel = PlayerModel(
        id = id,
        name = commonName,
        club = club,
        league = league,
        age = age,
        position = position,
        foot = foot,
        rating = rating,
        rarity = rarity
    )
}


/*
    @Json(name = "id") val id: Int?,
    @Json(name = "commonName") val name: String?,
    @Json(name = "club") val club: Int?,
    @Json(name = "league") val league: Int?,
    @Json(name = "age") val age: Int,
    @Json(name = "position") val position: String,
    @Json(name = "foot") val foot: String,
    @Json(name = "rating") val rating: Int,
    @Json(name = "rarity") val rarity: Int
 */