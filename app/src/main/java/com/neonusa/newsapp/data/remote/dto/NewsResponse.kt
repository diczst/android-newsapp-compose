package com.neonusa.newsapp.data.remote.dto

import com.neonusa.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)