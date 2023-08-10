package com.example.fifa.data.remote

import com.example.fifa.data.remote.dto.TeamDto
import com.example.fifa.data.remote.dto.PlayerDto

class RemoteDataSourceImpl(
    private val teamApi: TeamApi
) : RemoteDataSource {
    override suspend fun getTeamList(): List<TeamDto> {
        val times = 35
        var myList = mutableListOf<TeamDto>()
        for(i in 1..times) {
            for(item in teamApi.getTeamList(i).teams) myList.add(item)
        }
        return myList
    }
/*
    override suspend fun getTeamPhoto(teamId: Int): PhotoTeamDto {
        Log.w("Probando", "teamId = $teamId")
        return PhotoTeamDto(teamApi.getTeamUrl(teamId).body()?.bytes())
    }
*/

    override suspend fun getPlayersList(): List<PlayerDto> {
        val times = 500
        var myList = mutableListOf<PlayerDto>()
        for(i in 1..times) {
            for(item in teamApi.getPlayersList(i).players) myList.add(item)
        }
        return myList
    }
}