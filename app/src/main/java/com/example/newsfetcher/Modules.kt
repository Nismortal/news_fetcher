package com.example.newsfetcher

import com.example.newsfetcher.news.*
import com.example.newsfetcher.news.data.*
import com.example.newsfetcher.news.domain.NewsInteractor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_KEY = "34c099ae00284177867db815797aebb3"
const val BASE_URL = "https://newsapi.org/v2/"
val module = module {

    single<Retrofit> {
        Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
    single { get<Retrofit>().create(NewsApi::class.java) }
    single<NewsRepository> { NewsRepositoryImpl(get()) }
    single<NewsRemoteSource> { NewsRemoteSourceImpl(get()) }
    single { NewsInteractor(get()) }
    viewModel { NewsViewModel(get()) }

}