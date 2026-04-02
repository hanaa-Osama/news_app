package com.example.news_app.Routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.news_app.presentation.loginScreen.LoginScreen
import com.example.news_app.presentation.resultScreen.ResultScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.LoginScreen.route
    ){
        composable(
            route = Screens.LoginScreen.route,
        ){
            LoginScreen(
                onLoginSuccess = { userName ->
                    navController.navigate(Screens.ResultScreen.passUserName(userName))
                }
            )
        }

        composable(
            route = Screens.ResultScreen.route,
            arguments = listOf(
                navArgument("userName"){
                    type = NavType.StringType
                }
            )
        ){ backStackEntry ->
            val userName= backStackEntry.arguments?.getString("userName")
            ResultScreen(userName = userName ?: "User")
        }
    }
}