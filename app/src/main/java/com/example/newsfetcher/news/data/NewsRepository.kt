package com.example.newsfetcher.news.data

import com.example.newsfetcher.news.domain.ArticleModelDomain

interface NewsRepository {
    suspend fun getNews(): List<ArticleModelDomain>
}