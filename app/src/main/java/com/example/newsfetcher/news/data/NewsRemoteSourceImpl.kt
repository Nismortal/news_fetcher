package com.example.newsfetcher.news.data

class NewsRemoteSourceImpl(val api: NewsApi): NewsRemoteSource {
    override suspend fun getNews(): String {
        return api.getAllNews().toString()
    }
}