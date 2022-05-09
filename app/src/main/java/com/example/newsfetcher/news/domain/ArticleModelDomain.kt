package com.example.newsfetcher.news.domain

import com.google.gson.annotations.SerializedName

data class ArticleModelDomain(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)
