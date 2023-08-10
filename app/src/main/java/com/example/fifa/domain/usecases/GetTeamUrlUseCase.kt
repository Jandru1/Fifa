package com.example.fifa.domain.usecases

import com.example.fifa.data.TeamRepository

class GetTeamUrlUseCase (
    private val teamRepository: TeamRepository
) {
/*    suspend fun invoke(teamId: Int): PhotoTeamModel {
       // Log.w("ASDF", "teamId: $teamId")
        return teamRepository.getTeamUrl(teamId)
    }*/
}