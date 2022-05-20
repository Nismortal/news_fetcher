package com.example.newsfetcher.news.data

import com.example.newsfetcher.news.data.model.NewsModelRemote

class NewsRepositoryImpl(private val newsSource: NewsRemoteSource) : NewsRepository {
    override suspend fun getNews(): NewsModelRemote {
        return newsSource.getNews()
    }
}