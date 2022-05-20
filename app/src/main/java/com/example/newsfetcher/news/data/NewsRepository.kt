package com.example.newsfetcher.news.data

import com.example.newsfetcher.news.data.model.NewsModelRemote

interface NewsRepository {
    suspend fun getNews(): NewsModelRemote
}