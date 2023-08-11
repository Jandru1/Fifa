package com.example.fifa.data.repositories

import com.example.fifa.domain.model.PlayerModel

interface PlayerRepository{
    suspend fun getPlayersList(idTeam: Int): List<PlayerModel>

    suspend fun getPlayerDetail(playerId: Int): PlayerModel
}