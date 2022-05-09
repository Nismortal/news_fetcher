package com.example.newsfetcher.news.data

class NewsRepositoryImpl(val remote: NewsRemoteSource): NewsRepository {
    override suspend fun getNews(): String {
        return remote.getNews()
    }
}