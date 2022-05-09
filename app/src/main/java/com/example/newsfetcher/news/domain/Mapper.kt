package com.example.newsfetcher.news.domain

import com.example.newsfetcher.news.data.model.NewsModelRemote

fun NewsModelRemote.toDomain(): List<ArticleModelDomain> {
    return articlesList.map {
        ArticleModelDomain(
           author =  it.author ?: "",
           title = it.title ?: "",
           description = it.description ?: "",
           url = it.url ?: "",
           urlToImage = it.urlToImage ?: "",
            publishedAt = it.publishedAt ?: "",
            content = it.content ?: ""
        )
    }
}