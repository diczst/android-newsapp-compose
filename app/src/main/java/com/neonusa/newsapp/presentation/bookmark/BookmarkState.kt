package com.neonusa.newsapp.presentation.bookmark

import com.neonusa.newsapp.domain.model.Article
import com.neonusa.newsapp.domain.usecases.news.SelectArticles

data class BookmarkState(
    val articles: List<Article> = emptyList()
)