package com.example.fifa.data.mappers

import com.example.fifa.data.local.Model.TeamLocal
import com.example.fifa.data.remote.dto.ItemDto
import com.example.fifa.domain.model.ItemModel

fun ItemDto.toItemModel() = ItemModel(
    id = (id ?: 0) ,
    name = name ?: "",
    league = league ?: 0
)

fun ItemDto.toItemLocal() = TeamLocal(
    id = id ?: 0,
    name = name ?: "",
    league = league ?: 0,
)

fun TeamLocal.toItemModel() = ItemModel(
    id = id,
    name = name,
    league = league
)


