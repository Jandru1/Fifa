package com.example.fifa.domain.usecases

import com.example.fifa.data.TeamRepository

class GetTeamsListUseCase (
    private val teamRepository: TeamRepository
) {
    suspend fun invoke() = teamRepository.getTeamList()
}