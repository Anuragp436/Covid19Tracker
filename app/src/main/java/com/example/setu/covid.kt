package com.example.setu

import retrofit2.Response
import retrofit2.http.GET

interface Covid {
    @GET("data.json")
    suspend fun getUser(): Response<State>
}