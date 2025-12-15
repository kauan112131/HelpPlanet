package com.example.helpplanet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.helpplanet.ui.screens.HomeScreen
import com.example.helpplanet.ui.screens.ChallengeDetailsScreen

@Composable
fun HelpPlanetNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.HOME
    ) {

        composable(AppRoutes.HOME) {
            HomeScreen(
                onChallengeClick = { challengeId ->
                    navController.navigate("${AppRoutes.DETAILS}/$challengeId")
                }
            )
        }

        composable(
            route = "${AppRoutes.DETAILS}/{challengeId}",
            arguments = listOf(
                navArgument("challengeId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val challengeId =
                backStackEntry.arguments?.getInt("challengeId") ?: 0

            ChallengeDetailsScreen(
                challengeId = challengeId,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
