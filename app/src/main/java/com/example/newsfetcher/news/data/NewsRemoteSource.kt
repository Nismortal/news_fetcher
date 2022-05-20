package com.example.newsfetcher.news.data

import com.example.newsfetcher.news.data.model.NewsModelRemote

interface NewsRemoteSource {
    suspend fun getNews(): NewsModelRemote
}