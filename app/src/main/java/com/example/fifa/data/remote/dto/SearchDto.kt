package com.example.fifa.data.remote.dto

import com.squareup.moshi.Json

data class SearchDto (
    @Json(name = "page") val page: Int?
)