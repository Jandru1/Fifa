package com.example.fifa.data.remote

import com.example.fifa.data.remote.dto.ItemDto
import com.example.fifa.data.remote.dto.PhotoTeamDto
import com.example.fifa.data.remote.dto.PlayerDto
import com.example.fifa.data.remote.dto.TeamDto

interface RemoteDataSource {
    suspend fun getTeamList(): List<ItemDto>

    suspend fun getTeamPhoto(teamId: Int): PhotoTeamDto

    suspend fun getPlayersList(): List<PlayerDto>
}