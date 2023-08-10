package com.example.fifa.di

import com.example.fifa.presentation.detail.PlayerDetailViewModel
import com.example.fifa.presentation.playerslist.PlayerListViewModel
import com.example.fifa.presentation.teamlist.TeamListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentationModule = module {
    viewModel { TeamListViewModel(get()) }
    viewModel { PlayerListViewModel(get())}
    viewModel { PlayerDetailViewModel(get())}
}

