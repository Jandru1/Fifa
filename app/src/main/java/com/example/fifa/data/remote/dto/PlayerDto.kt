package com.example.fifa.data.remote.dto

import com.squareup.moshi.Json

class PlayerDto(
    @Json(name = "id") val id: Int?,
    @Json(name = "commonName") val name: String?,
    @Json(name = "club") val club: Int?,
    @Json(name = "league") val league: Int?,
    @Json(name = "age") val age: Int,
    @Json(name = "position") val position: String,
    @Json(name = "foot") val foot: String,
    @Json(name = "rating") val rating: Int,
    @Json(name = "rarity") val rarity: Int
)