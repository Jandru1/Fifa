package com.example.fifa.data.remote.dto

import com.squareup.moshi.Json

data class TeamDto(
  //  @Json(name = "pagination") val pagination: PaginationDto?,
    @Json(name = "items") val items: List<ItemDto>,
)