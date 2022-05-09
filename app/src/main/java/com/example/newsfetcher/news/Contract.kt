package com.example.newsfetcher.news

import com.example.newsfetcher.base.Event
import com.example.newsfetcher.news.domain.ArticleModelDomain

data class ViewState(
    val articles: List<ArticleModelDomain>
) 

sealed class UiEvent: Event {

    object OnTextClicked: UiEvent()

}

sealed class DataEvent: Event {

    data class RequestNews(val articles: List<ArticleModelDomain>): DataEvent()
}