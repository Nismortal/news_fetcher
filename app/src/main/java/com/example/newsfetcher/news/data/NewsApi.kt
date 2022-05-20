package com.example.newsfetcher.news.data

import com.example.newsfetcher.API_KEY
import com.example.newsfetcher.news.data.model.NewsModelRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getAllNews(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsModelRemote
}