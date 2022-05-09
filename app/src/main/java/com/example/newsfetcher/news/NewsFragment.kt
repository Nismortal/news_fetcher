package com.example.newsfetcher.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.newsfetcher.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment: Fragment(){

    private val viewModel: NewsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.textView).setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnTextClicked)
        }
        viewModel.viewState.observe(this.viewLifecycleOwner, ::render)
    }

    private fun render(state: ViewState) {
        view?.findViewById<TextView>(R.id.textView)?.let {
            it.text = state.text
        }
    }

}