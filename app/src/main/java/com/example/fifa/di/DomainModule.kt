package com.example.fifa.di

import com.example.fifa.domain.usecases.GetPlayerDetailUseCase
import com.example.fifa.domain.usecases.GetPlayersListUseCase
import com.example.fifa.domain.usecases.GetTeamUrlUseCase
import com.example.fifa.domain.usecases.GetTeamsListUseCase
import org.koin.dsl.module


val domainModule = module {
    single { GetTeamsListUseCase(get()) }
    single { GetTeamUrlUseCase(get()) }
    single { GetPlayersListUseCase(get())}
    single { GetPlayerDetailUseCase(get())}
}
