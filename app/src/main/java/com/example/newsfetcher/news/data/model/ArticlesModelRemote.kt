package com.example.newsfetcher.news.data.model

import com.google.gson.annotations.SerializedName

data class ArticlesModelRemote(
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("urlToImage")
    val urlToImage: String?
)