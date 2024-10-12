package com.neonusa.newsapp.domain.usecases.news

import com.neonusa.newsapp.data.local.NewsDao
import com.neonusa.newsapp.domain.model.Article

class DeleteArticle (
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article){
        newsDao.delete(article)
    }
}