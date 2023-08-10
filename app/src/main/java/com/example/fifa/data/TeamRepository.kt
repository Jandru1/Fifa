package com.example.fifa.data

import com.example.fifa.domain.model.TeamModel

interface TeamRepository {

    suspend fun getTeamList(): List<TeamModel>

    //suspend fun getTeamUrl(teamId: Int): PhotoTeamModel

}