package com.example.news_app.presentation.newsScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.domain.model.NewsModel
import com.example.news_app.domain.useCase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    private val _newsState = MutableStateFlow<List<NewsModel>>(emptyList())
    val newsState: StateFlow<List<NewsModel>> = _newsState

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    getNewsUseCase()
                }
                _newsState.value = result
            } catch (e: Exception) {

                Log.e("NewsViewModel", "Error fetching news: ${e.message}")
                _newsState.value = emptyList()
            }
        }
    }
}
