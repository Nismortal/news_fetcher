package com.example.newsfetcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newsfetcher.news.presentation.NewsFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, NewsFragment())
            .commit()
    }
}