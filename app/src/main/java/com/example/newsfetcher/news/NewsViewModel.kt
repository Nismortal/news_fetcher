package com.example.newsfetcher.news

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.news.domain.NewsInteractor
import kotlinx.coroutines.launch

class NewsViewModel(val interactor: NewsInteractor) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState {
        return ViewState(listOf())
    }

    init {
        viewModelScope.launch {
            interactor.getNews().fold(
                onError = { it.message?.let { it1 -> Log.e("ERROR", it1) } },
                onSuccess = { processDataEvent(DataEvent.RequestNews(it)) }
            )
        }
    }

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.RequestNews -> {
               return previousState.copy(
                    articles = event.articles
                )
            }
        }
        return null
    }
}