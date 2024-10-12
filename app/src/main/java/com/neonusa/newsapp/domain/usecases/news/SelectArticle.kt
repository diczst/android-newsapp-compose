package com.neonusa.newsapp.domain.usecases.news

import com.neonusa.newsapp.data.local.NewsDao
import com.neonusa.newsapp.domain.model.Article

class SelectArticle (
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url)
    }
}