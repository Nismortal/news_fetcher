package com.example.newsfetcher.news.domain

import com.example.newsfetcher.news.data.model.ArticlesModelRemote
import com.example.newsfetcher.news.data.model.NewsModelRemote

fun ArticlesModelRemote.toDomain(): ArticleModelDomain {
    return ArticleModelDomain(
        title = this.title ?: "",
        description = this.description ?: "",
        urlToImage = this.urlToImage ?: "",
    )
}

fun NewsModelRemote.toDomain(): NewsModelDomain {
    return NewsModelDomain(
        articlesList = this.articlesList.map { it.toDomain() }
    )
}