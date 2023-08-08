package com.example.fifa.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost( // FragmentContainerView
        navController = navController,
        startDestination = Screen.LoginScreen.route, // Igual que el startDestination
    ) {
        addLoginScreen(navController)
        addTeamListScreen(navController = navController)
        addPlayersListScreen(navController = navController)
        addPlayerDetailScreen(navController = navController)
       // addTeamsListScreen(navController)
    }
}