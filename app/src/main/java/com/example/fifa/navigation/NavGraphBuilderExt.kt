package com.example.fifa.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.fifa.presentation.detail.PlayerDetailScreen
import com.example.fifa.presentation.login.LoginScreen
import com.example.fifa.presentation.playerslist.PlayersListScreen
import com.example.fifa.presentation.teamlist.TeamListScreen

fun NavGraphBuilder.addLoginScreen(navController: NavController) {
    composable(Screen.LoginScreen.route) {

        LoginScreen{
            navController.navigate(Screen.TeamsScreen.route)
        }
    }
}

fun NavGraphBuilder.addTeamListScreen(navController: NavController) {
    composable(Screen.TeamsScreen.route) {
        TeamListScreen( { idTeam ->
            navController.navigate("${Screen.PlayersScreen.route}/$idTeam")
        })
    }
}


fun NavGraphBuilder.addPlayersListScreen(navController: NavController) {
    composable(
        route = Screen.PlayersScreen.route + "/{idTeam}",
        arguments = Screen.PlayersScreen.arguments
    ){ navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getInt("idTeam") ?: -1
        PlayersListScreen(idTeam = id,
            { idPlayer ->
                navController.navigate("${Screen.PlayerDetailScreen.route}/${idPlayer.id}") }
        ,
            {
                navController.navigate(Screen.TeamsScreen.route)
            }
        )
    }
}

fun NavGraphBuilder.addPlayerDetailScreen(navController: NavController) {
    composable(
        route =  Screen.PlayerDetailScreen.route +"/{playerId}",
        arguments = Screen.PlayerDetailScreen.arguments
    ) { navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getInt("playerId") ?: -1
        PlayerDetailScreen(playerId = id,
            {teamId ->
                navController.navigate("${Screen.PlayersScreen.route}/$teamId")}
        )
    }
}
