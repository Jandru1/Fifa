package com.example.fifa.data.remote

import android.util.Log
import com.example.fifa.data.remote.dto.ItemDto
import com.example.fifa.data.remote.dto.PhotoTeamDto
import com.example.fifa.data.remote.dto.PlayerDto
import com.example.fifa.data.remote.dto.SearchDto
import com.example.fifa.data.remote.dto.TeamDto

class RemoteDataSourceImpl(
    private val teamApi: TeamApi
) : RemoteDataSource {
    override suspend fun getTeamList(): List<ItemDto> {
        val times = 35
        var myList = mutableListOf<ItemDto>()
        for(i in 1..times) {
            for(item in teamApi.getTeamList1(i).items) myList.add(item)
        }
        return myList
    }
    override suspend fun getTeamPhoto(teamId: Int): PhotoTeamDto {
        Log.w("Probando", "teamId = $teamId")
        return PhotoTeamDto(teamApi.getTeamUrl(teamId).body()?.bytes())
    }

    override suspend fun getPlayersList(): List<PlayerDto> {
        val times = 500
        var myList = mutableListOf<PlayerDto>()
        for(i in 1..times) {
            for(item in teamApi.getPlayersList(i).players) myList.add(item)
        }
        return myList
    }
}