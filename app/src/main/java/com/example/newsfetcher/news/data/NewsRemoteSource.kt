package com.example.newsfetcher.news.data

import com.example.newsfetcher.news.data.model.ArticlesModelRemote
import com.example.newsfetcher.news.data.model.NewsModelRemote
import com.example.newsfetcher.news.domain.ArticleModelDomain

interface NewsRemoteSource {
    suspend fun getNews(): NewsModelRemote
}