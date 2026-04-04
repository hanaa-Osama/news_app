package com.example.news_app.Routes

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {
    @Serializable
    object LoginScreen : Screens()

    @Serializable
    data class NewsScreen(val userName: String) : Screens()

    @Serializable
    data class NewsDetailScreen(val title: String, val description: String) : Screens()
}
