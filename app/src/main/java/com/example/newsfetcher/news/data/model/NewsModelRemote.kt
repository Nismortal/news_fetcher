package com.example.newsfetcher.news.data.model

import com.google.gson.annotations.SerializedName

data class NewsModelRemote(
    @SerializedName("articles")
    val articlesList: List<ArticlesModelRemote>
)
/*

    "status": "ok",
    "totalResults": 38,
    -
    "articles": [
    -
    {
        -
        "source": {
        "id": "cnn",
        "name": "CNN"
    },
        "author": "Jackie Wattles, CNN Business",
        "title": "SpaceX's wildly busy year continues with astronaut splashdown - CNN",
        "description": "Three NASA astronauts and a European astronaut splashed down aboard their SpaceX Crew Dragon capsule off the coast of Florida after midnight Friday morning, capping off their six-month mission during which they worked alongside Russian cosmonauts and hosted t…",
        "url": "https://www.cnn.com/2022/05/06/tech/spacex-crew-3-nasa-splashdown-scn/index.html",
        "urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/220506004631-01-spacex-crew3-splashdown-0506-super-tease.jpg",
        "publishedAt": "2022-05-06T14:30:00Z",
        "content": "New York (CNN Business)Three NASA astronauts and a European astronaut splashed down aboard their SpaceX Crew Dragon capsule off the coast of Florida after midnight Friday morning, capping off their s… [+2469 chars]"
    },s*/