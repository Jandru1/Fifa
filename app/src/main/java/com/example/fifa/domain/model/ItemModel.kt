package com.example.fifa.domain.model

class ItemModel (
    val id: Int,
    val name: String,
    val league: Int,
    var escudo : PhotoTeamModel = PhotoTeamModel(ByteArray(0))
)