package com.example.fifa.data.mappers

import com.example.fifa.data.local.Model.TeamLocal
import com.example.fifa.data.remote.dto.TeamDto
import com.example.fifa.domain.model.TeamModel

fun TeamDto.toItemModel() = TeamModel(
    id = (id ?: 0) ,
    name = name ?: "",
    league = league ?: 0
)

fun TeamDto.toItemLocal() = TeamLocal(
    id = id ?: 0,
    name = name ?: "",
    league = league ?: 0,
)

fun TeamLocal.toItemModel() = TeamModel(
    id = id,
    name = name,
    league = league
)


