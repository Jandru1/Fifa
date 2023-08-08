package com.example.fifa.domain.usecases

import android.util.Log
import com.example.fifa.data.TeamRepository
import com.example.fifa.domain.model.PhotoTeamModel

class GetTeamUrlUseCase (
    private val teamRepository: TeamRepository
) {
    suspend fun invoke(teamId: Int): PhotoTeamModel {
       // Log.w("ASDF", "teamId: $teamId")
        return teamRepository.getTeamUrl(teamId)
    }
}