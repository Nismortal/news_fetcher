package com.example.newsfetcher.news.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfetcher.R
import com.example.newsfetcher.news.domain.ArticleModelDomain
import com.squareup.picasso.Picasso

class ArticleAdapter(val onClicked: () -> Unit) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    var items: List<ArticleModelDomain> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(items[position])

    }

    override fun getItemCount() = items.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView
        val description: TextView
        val image: ImageView
        val card: CardView

        init {
            title = view.findViewById(R.id.title)
            description = view.findViewById(R.id.description)
            image = view.findViewById(R.id.image)
            card = view.findViewById(R.id.card)
        }

        fun setItem(articleModel: ArticleModelDomain) {
            title.text = articleModel.title
            description.text = articleModel.description

            card.setOnClickListener {
                this@ArticleAdapter.onClicked()
            }

            if (articleModel.urlToImage != "") {
                image.visibility = View.VISIBLE
                Picasso.get().load(articleModel.urlToImage).into(image)
            } else {
                image.visibility = View.GONE
                image.setImageDrawable(null)
            }
        }
    }
}
