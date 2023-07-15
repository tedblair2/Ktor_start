package com.example.ktor_first.network

import com.example.ktor_first.model.Quote
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ApiServiceImpl(private val httpClient: HttpClient) : ApiService {

    override suspend fun getQuotes(): List<Quote> {
        return try{
            httpClient.get("/v1/quotes"){
                parameter("category","humor")
                parameter("limit",5)
            }.body()
        }catch (e:Exception){
            e.printStackTrace()
            emptyList()
        }
    }
}