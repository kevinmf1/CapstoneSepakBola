package com.fashionism.core.domain.repository

import com.fashionism.core.data.Resource
import com.fashionism.core.domain.model.Player
import kotlinx.coroutines.flow.Flow

@Suppress("unused", "unused")
interface IPlayerRepository {

    fun getAllPlayer(): Flow<Resource<List<Player>>>

    fun getPlayerByName(name: String): Flow<List<Player>>

    fun getFavoritePlayer(): Flow<List<Player>>

    fun setFavoritePlayer(player: Player, state: Boolean)

}