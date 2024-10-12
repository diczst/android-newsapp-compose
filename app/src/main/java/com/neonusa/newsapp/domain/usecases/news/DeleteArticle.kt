package com.neonusa.newsapp.domain.usecases.news

import com.neonusa.newsapp.data.local.NewsDao
import com.neonusa.newsapp.domain.model.Article
import com.neonusa.newsapp.domain.reposistory.NewsRepository

class DeleteArticle (
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article){
        newsRepository.deleteArticle(article)
    }
}