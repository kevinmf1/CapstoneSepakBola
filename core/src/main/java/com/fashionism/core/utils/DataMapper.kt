

package com.fashionism.core.utils

import com.fashionism.core.data.source.local.entity.PlayerEntity
import com.fashionism.core.data.source.remote.response.PlayerResponse
import com.fashionism.core.domain.model.Player

@Suppress("unused", "unused")
object DataMapper {

    fun mapResponsesToEntities(input: List<PlayerResponse>): List<PlayerEntity> {
        val playerList = ArrayList<PlayerEntity>()
        input.map {
            val player = PlayerEntity(
                idPlayer = it.id,
                name = it.name,
                club = it.club,
                rate = it.rate,
                position = it.position,
                allGoalsUntilNow = it.allGoalUntilNow,
                allAssistsUntilNow = it.allAssistUntilNow,
                activePlayer = it.activePlayer,
                description = it.description,
                photo = it.photo,
                isFavorite = false
            )
            playerList.add(player)
        }
        return playerList
    }

    fun mapEntitiesToDomain(input: List<PlayerEntity>): List<Player> =
        input.map {
            Player(
                idPlayer = it.idPlayer,
                name = it.name,
                club = it.club,
                rate = it.rate,
                position = it.position,
                allGoalsUntilNow = it.allGoalsUntilNow,
                allAssistsUntilNow = it.allAssistsUntilNow,
                activePlayer = it.activePlayer,
                description = it.description,
                photo = it.photo,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Player) = PlayerEntity(
        idPlayer = input.idPlayer,
        name = input.name,
        club = input.club,
        rate = input.rate,
        position = input.position,
        allGoalsUntilNow = input.allGoalsUntilNow,
        allAssistsUntilNow = input.allAssistsUntilNow,
        activePlayer = input.activePlayer,
        description = input.description,
        photo = input.photo,
        isFavorite = input.isFavorite
    )

    fun mapDomainToResponse(input: Player): PlayerResponse =
        PlayerResponse(
            id = input.idPlayer,
            name = input.name,
            club = input.club,
            rate = input.rate,
            position = input.position,
            allGoalUntilNow = input.allGoalsUntilNow,
            allAssistUntilNow = input.allAssistsUntilNow,
            activePlayer = input.activePlayer,
            description = input.description,
            photo = input.photo
        )
}