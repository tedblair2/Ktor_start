package com.example.ktor_first.network

import com.example.ktor_first.resources.Resources
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class KtorHttpClient {

    fun getHttpClient():HttpClient{
        return HttpClient(Android) {
            install(Logging) {
                level = LogLevel.HEADERS
            }
            install(DefaultRequest) {
                url(Resources.BASE_URL)
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                header("X-Api-Key", Resources.API_KEY)
            }
            install(ContentNegotiation){
                json(Json{
                    prettyPrint=true
                    isLenient=true
                })
            }
            engine {
                socketTimeout=15_000
                connectTimeout=15_000
            }
        }
    }
}