package com.example.news_app.Routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.news_app.presentation.loginScreen.LoginScreen
import com.example.news_app.presentation.newsScreen.NewsScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.LoginScreen
    ) {

        composable<Screens.LoginScreen> {
            LoginScreen(
                onLoginSuccess = { userName ->
                    navController.navigate(Screens.NewsScreen(userName = userName))
                }
            )
        }


        composable<Screens.NewsScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<Screens.NewsScreen>()

            NewsScreen(userName = args.userName)
        }
    }
}