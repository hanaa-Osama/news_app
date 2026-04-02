package com.example.news_app.presentation.newsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.domain.model.NewsModel
import com.example.news_app.domain.useCase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
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

    private fun getNews(){
        viewModelScope.launch {
            _newsState.value = getNewsUseCase()
        }
    }

}