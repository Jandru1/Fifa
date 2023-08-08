package com.example.fifa.data

import com.example.fifa.domain.model.ItemModel
import com.example.fifa.domain.model.PhotoTeamModel

interface TeamRepository {

    suspend fun getTeamList(): List<ItemModel>

    suspend fun getTeamUrl(teamId: Int): PhotoTeamModel

}