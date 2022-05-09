package com.example.newsfetcher.news

import com.example.newsfetcher.base.Event

data class ViewState(
    val text: String
) 

sealed class UiEvent: Event {

    object OnTextClicked: UiEvent()

}

sealed class DataEvent: Event {

    data class RequestNews(val text: String): DataEvent()
}