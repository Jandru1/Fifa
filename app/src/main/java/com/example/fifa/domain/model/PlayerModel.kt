package com.example.fifa.domain.model

data class PlayerModel (
    val id:Int,
    val name: String,
    val club: Int,
    val league: Int,
    val age: Int,
    val position: String,
    val foot: String,
    val rating: Int,
    val rarity: Int
        )