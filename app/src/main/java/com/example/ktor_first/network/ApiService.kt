package com.example.ktor_first.network

import com.example.ktor_first.model.Quote

interface ApiService {

    suspend fun getQuotes():List<Quote>

    companion object{
        fun getRequest():ApiService{
            return ApiServiceImpl(KtorHttpClient().getHttpClient())
        }
    }
}