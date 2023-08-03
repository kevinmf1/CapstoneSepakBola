package com.fashionism.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

@Suppress("unused", "unused")
data class ListPlayerResponse(

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("data")
    val data: List<PlayerResponse>
)
