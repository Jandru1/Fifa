package com.example.fifa.data.remote.dto

import com.squareup.moshi.Json

data class TeamListDto(
  //  @Json(name = "pagination") val pagination: PaginationDto?,
    @Json(name = "items") val teams: List<TeamDto>,
)

