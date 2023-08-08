package com.example.fifa.data.mappers

import com.example.fifa.data.local.Model.PlayerLocal
import com.example.fifa.data.remote.dto.PlayerDto
import com.example.fifa.domain.model.PlayerModel

fun PlayerDto.toPlayerModel() = PlayerModel(
    id = id ?: -1,
    name = name ?: "none",
    club = club ?: -1,
    league = league ?: -1
)

fun PlayerDto.toPlayerLocal() = PlayerLocal(
    id = id ?: -1,
    name = name ?: "none",
    club = club ?: -1,
    league = league ?: -1

)

fun PlayerLocal.toPlayerModel() = PlayerModel(
    id = id ?: -1,
    name = name ?: "none",
    club = club ?: -1,
    league = league ?: -1
)