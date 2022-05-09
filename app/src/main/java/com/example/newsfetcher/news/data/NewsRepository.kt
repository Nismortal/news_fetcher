package com.example.newsfetcher.news.data

interface NewsRepository {
    suspend fun getNews():String
}