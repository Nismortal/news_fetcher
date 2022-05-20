package com.example.newsfetcher.news.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfetcher.R
import com.example.newsfetcher.news.presentation.adapter.ArticleAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : Fragment() {

    val rv: RecyclerView by lazy { requireView().findViewById(R.id.rv) }
    val adapter = ArticleAdapter(onClicked = {
        requireActivity().supportFragmentManager.beginTransaction().replace(
            android.R.id.content, DetailsFragment()
        ).commit()
    })

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
        viewModel.viewState.observe(this.viewLifecycleOwner, ::render)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun render(state: ViewState) {
        adapter.items = state.articles
    }

}