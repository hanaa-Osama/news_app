package com.example.news_app.Routes

sealed class Screens(val route: String) {
    object LoginScreen: Screens("login_screen")
    object NewsScreen: Screens("news_screen/{userName}"){
        fun passUserName(userName: String): String{
            return "news_screen/$userName"
        }
    }
}

