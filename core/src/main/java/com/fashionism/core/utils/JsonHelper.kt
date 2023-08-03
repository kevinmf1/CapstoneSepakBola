package com.fashionism.core.utils

import android.content.Context
import com.fashionism.core.R
import com.fashionism.core.data.source.remote.response.PlayerResponse
import org.json.JSONObject
import java.io.IOException

@Suppress("unused", "unused")
class JsonHelper(private val context: Context) {

    private fun parsingFileToString(): String? {
        val jsonString: String
        try {
            jsonString = context.resources.openRawResource(R.raw.player).bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun loadData(): List<PlayerResponse> {
        val list = ArrayList<PlayerResponse>()
        val responseObject = JSONObject(parsingFileToString().toString())
        val jsonArray = responseObject.getJSONArray("data")

        for (i in 0 until jsonArray.length()) {
            val player = jsonArray.getJSONObject(i)

            val idPlayer = player.getInt("id")
            val playerName = player.getString("name")
            val playerClub = player.getString("club")
            val playerRate = player.getString("rate")
            val playerPosition = player.getString("position")
            val playerAllGoalUntilNow = player.getInt("allGoalUntilNow")
            val playerAllAssistUntilNow = player.getInt("allAssistUntilNow")
            val playerActivePlayer = player.getString("activePlayer")
            val playerDescription = player.getString("description")
            val playerPhoto = player.getString("photo")

            val playerResponse = PlayerResponse(
                id = idPlayer,
                name = playerName,
                club = playerClub,
                rate = playerRate,
                position = playerPosition,
                allGoalUntilNow = playerAllGoalUntilNow,
                allAssistUntilNow = playerAllAssistUntilNow,
                activePlayer = playerActivePlayer,
                description = playerDescription,
                photo = playerPhoto
            )
            list.add(playerResponse)
        }
        return list
    }
}