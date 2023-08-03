package com.fashionism.core.utils

import com.fashionism.core.data.source.local.entity.PlayerEntity

object DataDummy {

    fun generateDummyPlayer(): List<PlayerEntity> {

        val playerList = ArrayList<PlayerEntity>()

        for (i in 0..9) {
            val player = PlayerEntity(
                idPlayer = i,
                name = "Kevin De Bruyne $i",
                club = "Manchester City $i",
                rate = "9.5 $i",
                position = "Midfielder $i",
                allGoalsUntilNow = i,
                allAssistsUntilNow = i,
                activePlayer = "Active $i",
                description = "Description $i",
                photo = "https://picsum.photos/id/$i/200/300",
                isFavorite = false
            )
            playerList.add(player)
        }

        return playerList
    }
}
