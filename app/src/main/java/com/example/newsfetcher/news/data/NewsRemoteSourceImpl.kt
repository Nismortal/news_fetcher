package com.example.newsfetcher.news.data

import com.example.newsfetcher.news.data.model.NewsModelRemote

class NewsRemoteSourceImpl(private val api: NewsApi): NewsRemoteSource {
    override suspend fun getNews(): NewsModelRemote {
        return api.getAllNews()
    }
}