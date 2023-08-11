package com.example.fifa.domain.usecases

import com.example.fifa.data.repositories.PlayerRepository

class GetPlayerDetailUseCase(
    private val playerRepository: PlayerRepository
) {
    suspend fun invoke(playerId: Int) = playerRepository.getPlayerDetail(playerId)
}