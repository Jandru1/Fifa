package com.example.fifa.data.remote.dto

import com.squareup.moshi.Json

class ItemDto (
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "league") val league: Int?,
)