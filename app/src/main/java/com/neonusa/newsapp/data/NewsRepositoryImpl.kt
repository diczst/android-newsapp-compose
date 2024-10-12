package com.neonusa.newsapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.neonusa.newsapp.data.local.NewsDao
import com.neonusa.newsapp.data.remote.NewsApi
import com.neonusa.newsapp.data.remote.NewsPagingSource
import com.neonusa.newsapp.data.remote.SearchNewsPagingSource
import com.neonusa.newsapp.domain.model.Article
import com.neonusa.newsapp.domain.reposistory.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class NewsRepositoryImpl(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
): NewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(newsApi = newsApi, sources = sources.joinToString(separator = ","))
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    api = newsApi,
                    searchQuery = searchQuery,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override suspend fun insertArticle(article: Article) {
        newsDao.insert(article)
    }

    override suspend fun deleteArticle(article: Article) {
        newsDao.delete(article)

    }

    override fun selectArticles(): Flow<List<Article>> {
        return newsDao.getArticles().onEach { it.reversed() }
    }

    override suspend fun selectArticle(url: String): Article? {
        return newsDao.getArticle(url)
    }


}