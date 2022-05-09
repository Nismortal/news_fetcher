package com.example.newsfetcher.news

import android.util.Log
import android.view.View
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class NewsViewModel(val interactor: NewsInteractor) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState {
        return ViewState("FirstState")
    }

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            UiEvent.OnTextClicked -> {
                viewModelScope.launch {
                    interactor.getNews().fold(
                        onError = { it.message?.let { it1 -> Log.e("ERROR", it1) } },
                        onSuccess = { processDataEvent(DataEvent.RequestNews(it)) }
                    )
                }
                return null
            }
            is DataEvent.RequestNews -> {
               return previousState.copy(
                    text = event.text
                )
            }
        }
        return null
    }
}