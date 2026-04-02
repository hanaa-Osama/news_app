package com.example.news_app.di

import android.content.Context
import androidx.room.Room
import com.example.news_app.Utils.Constance
import com.example.news_app.Utils.Constance.DATABASE_NAME
import com.example.news_app.data.dataSource.local.NewsDao
import com.example.news_app.data.dataSource.local.NewsDatabase
import com.example.news_app.data.dataSource.remote.NewsAPIService
import com.example.news_app.data.repositoryImp.NewsRepoImp
import com.example.news_app.domain.repository.NewsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constance.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsApiService(retrofit: Retrofit): NewsAPIService {
        return retrofit.create(NewsAPIService::class.java)
    }


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NewsDatabase {
        return Room.databaseBuilder(
            context,
            NewsDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(database: NewsDatabase): NewsDao {
        return database.newsDao()
    }

    @Provides
    @Singleton
    fun provideNewsRepo(
        apiService: NewsAPIService,
        newsDao: NewsDao
    ): NewsRepo {
        return NewsRepoImp(apiService, newsDao)
    }
}