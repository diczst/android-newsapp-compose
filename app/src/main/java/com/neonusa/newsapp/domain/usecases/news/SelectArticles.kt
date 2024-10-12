package com.neonusa.newsapp.domain.usecases.news

import com.neonusa.newsapp.data.local.NewsDao
import com.neonusa.newsapp.domain.model.Article
import com.neonusa.newsapp.domain.reposistory.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles (
    private val newsRepository: NewsRepository
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticles()
    }
}