package com.example.newsfetcher

import com.example.newsfetcher.news.data.*
import com.example.newsfetcher.news.domain.NewsInteractor
import com.example.newsfetcher.news.presentation.NewsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_KEY = "646a452a5af640efa6b91eb56ec4b3e1"
const val BASE_URL = "https://newsapi.org/v2/"
val module = module {

    single<Retrofit> {
        Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .build()
    }
    single { get<Retrofit>().create(NewsApi::class.java) }
    single<NewsRepository> { NewsRepositoryImpl(get()) }
    single<NewsRemoteSource> { NewsRemoteSourceImpl(get()) }
    single { NewsInteractor(get()) }
    viewModel { NewsViewModel(get()) }

}