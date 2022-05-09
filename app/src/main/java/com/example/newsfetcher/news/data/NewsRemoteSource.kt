package com.example.newsfetcher.news.data

interface NewsRemoteSource {
    suspend fun getNews(): String
}