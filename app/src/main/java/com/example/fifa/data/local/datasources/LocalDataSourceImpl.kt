package com.example.fifa.data.local.datasources

import com.example.fifa.data.local.Model.PlayerLocal
import com.example.fifa.data.local.Model.TeamLocal
import com.example.fifa.data.local.dao.PlayerDao
import com.example.fifa.data.local.dao.TeamDao

class LocalDataSourceImpl(
    private val teamDao: TeamDao,
    private val playerDao: PlayerDao
) : LocalDataSource {

    override suspend fun insertTeamList(teamList: List<TeamLocal>) = teamDao.insertAll(teamList)
    override suspend fun getTeamList(): List<TeamLocal> = teamDao.getAll()
    override suspend fun insertPlayersList(playersList: List<PlayerLocal>) = playerDao.insertAll(playersList)
    override suspend fun getPlayerList(idTeam: Int): List<PlayerLocal> = playerDao.getAll(idTeam)
    override suspend fun getPlayerDetail(playerId: Int): PlayerLocal = playerDao.getPlayerDetail(playerId)
}