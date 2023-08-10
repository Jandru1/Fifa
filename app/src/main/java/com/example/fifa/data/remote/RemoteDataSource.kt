package com.example.fifa.data.remote

import com.example.fifa.data.remote.dto.TeamDto
import com.example.fifa.data.remote.dto.PlayerDto

interface RemoteDataSource {
    suspend fun getTeamList(): List<TeamDto>

   // suspend fun getTeamPhoto(teamId: Int): PhotoTeamDto

    suspend fun getPlayersList(): List<PlayerDto>
}