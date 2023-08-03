package com.fashionism.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

@Suppress("unused", "unused")
data class PlayerResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("club")
    val club: String,

    @field:SerializedName("rate")
    val rate: String,

    @field:SerializedName("position")
    val position: String,

    @field:SerializedName("allGoalUntilNow")
    val allGoalUntilNow: Int,

    @field:SerializedName("allAssistUntilNow")
    val allAssistUntilNow: Int,

    @field:SerializedName("activePlayer")
    val activePlayer: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("photo")
    val photo: String
)
