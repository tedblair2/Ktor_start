package com.example.ktor_first.model

@kotlinx.serialization.Serializable
data class Quote(
    val author: String?,
    val category: String?,
    val quote: String?
)