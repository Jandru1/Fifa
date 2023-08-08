package com.example.fifa.domain.usecases

import com.example.fifa.data.PlayerRepository

class GetPlayersListUseCase (
    private val playersRepository: PlayerRepository
        ) {
    suspend fun invoke(idTeam: Int) = playersRepository.getPlayersList(idTeam)
}