package com.example.fifa.data.local

import com.example.fifa.data.local.Model.PlayerLocal
import com.example.fifa.data.local.Model.TeamLocal
import com.example.fifa.domain.model.PlayerModel


interface LocalDataSource {
    suspend fun insertTeamList(teamList: List<TeamLocal>)

    suspend fun getTeamList():List<TeamLocal>

    suspend fun insertPlayersList(payersList: List<PlayerLocal>)

    suspend fun getPlayerList(idTeam: Int):List<PlayerLocal>

    suspend fun getPlayerDetail(playerId: Int): PlayerLocal

}