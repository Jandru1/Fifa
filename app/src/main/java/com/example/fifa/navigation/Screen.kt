package com.example.fifa.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen (
    val route: String,
    val arguments: List<NamedNavArgument>
    ) {

    object LoginScreen : Screen(
        route = "login",
        arguments = emptyList()
    )


    object TeamsScreen : Screen(
        route = "teamsList",
        arguments = emptyList()
    )

    object PlayersScreen : Screen(
        route = "playersScreen",
        arguments = listOf(
            navArgument("idTeam") {
                type = NavType.IntType
                nullable = false
            }
        )
    )

    object PlayerDetailScreen: Screen (
        route = "playerDetailScreen",
        arguments = listOf(
            navArgument("playerId") {
                type = NavType.IntType
                nullable = false
            }
        )
    )

}