package com.example.newsfetcher.news

import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.news.data.NewsRepository

class NewsInteractor(private val repo: NewsRepository) {
    suspend fun getNews() = attempt { repo.getNews() }
}