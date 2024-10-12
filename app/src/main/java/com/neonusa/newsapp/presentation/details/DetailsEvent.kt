package com.neonusa.newsapp.presentation.details

import com.neonusa.newsapp.domain.model.Article

sealed class DetailsEvent {
    data class InsertDeleteArticle(val article: Article): DetailsEvent()
    object RemoveSideEffect: DetailsEvent()
}