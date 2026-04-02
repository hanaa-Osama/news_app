package com.example.news_app.Routes

sealed class Screens(val route: String) {
    object LoginScreen: Screens("login_screen")
    object ResultScreen: Screens("result_screen/{userName}"){
        fun passUserName(userName: String): String{
            return "result_screen/$userName"
        }
    }
}

