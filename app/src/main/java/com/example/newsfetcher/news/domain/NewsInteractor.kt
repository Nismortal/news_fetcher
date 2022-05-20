package com.example.newsfetcher.news.domain

import com.example.newsfetcher.base.Either
import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.news.data.NewsRepository

class NewsInteractor(private val newsRepository: NewsRepository) {
    suspend fun getNews(): Either<Throwable, List<ArticleModelDomain>> = attempt {
        newsRepository.getNews().toDomain().articlesList
    }

//    suspend fun getNews() {
//        val fromRemote = attempt { newsRepository.getNews().toDomain().articlesList }
//        val lce = fromRemote.fold(
//            onError = { },
//            onSuccess = {}
//        )
//    }
}
