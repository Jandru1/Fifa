package com.example.fifa.data.remote.dto

import com.example.fifa.domain.model.PlayerModel
import com.squareup.moshi.Json

data class PlayersListDto(
    @Json(name = "items") val players: List<PlayerDto>
)