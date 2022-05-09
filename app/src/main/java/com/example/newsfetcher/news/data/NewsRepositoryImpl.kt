package com.example.newsfetcher.news.data

import com.example.newsfetcher.news.domain.ArticleModelDomain
import com.example.newsfetcher.news.domain.toDomain

class NewsRepositoryImpl(private val remote: NewsRemoteSource): NewsRepository {
    override suspend fun getNews(): List<ArticleModelDomain> {
        return remote.getNews().toDomain()
    }
}