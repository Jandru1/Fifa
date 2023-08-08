package com.example.fifa.data.mappers

import com.example.fifa.data.remote.dto.ItemDto
import com.example.fifa.data.remote.dto.PhotoTeamDto
import com.example.fifa.domain.model.ItemModel
import com.example.fifa.domain.model.PhotoTeamModel


fun PhotoTeamDto.toPhotoTeamModel() = PhotoTeamModel(
    byteArray = byteArray ?: ByteArray(0)
)
