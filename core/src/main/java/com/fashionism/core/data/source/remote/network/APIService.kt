package com.fashionism.core.data.source.remote.network

import com.fashionism.core.data.source.remote.response.ListPlayerResponse
import retrofit2.http.GET

interface APIService {

    @GET("players")
    suspend fun getList(): ListPlayerResponse
}