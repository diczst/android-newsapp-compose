package com.neonusa.newsapp.di

import android.app.Application
import androidx.room.Room
import com.neonusa.newsapp.data.NewsRepositoryImpl
import com.neonusa.newsapp.data.local.NewsDao
import com.neonusa.newsapp.data.local.NewsDatabase
import com.neonusa.newsapp.data.local.NewsTypeConverter
import com.neonusa.newsapp.data.manager.LocalUserManagerImpl
import com.neonusa.newsapp.data.remote.NewsApi
import com.neonusa.newsapp.domain.LocalUserManager
import com.neonusa.newsapp.domain.reposistory.NewsRepository
import com.neonusa.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.neonusa.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.neonusa.newsapp.domain.usecases.app_entry.SaveAppEntry
import com.neonusa.newsapp.domain.usecases.news.DeleteArticle
import com.neonusa.newsapp.domain.usecases.news.GetNews
import com.neonusa.newsapp.domain.usecases.news.InsertArticle
import com.neonusa.newsapp.domain.usecases.news.NewsUseCases
import com.neonusa.newsapp.domain.usecases.news.SearchNews
import com.neonusa.newsapp.domain.usecases.news.SelectArticle
import com.neonusa.newsapp.domain.usecases.news.SelectArticles
import com.neonusa.newsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi,newsDao)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            insertArticle = InsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            selectArticle = SelectArticle(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}