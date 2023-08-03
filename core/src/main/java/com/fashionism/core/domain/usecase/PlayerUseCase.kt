package com.fashionism.core.domain.usecase

import com.fashionism.core.data.Resource
import com.fashionism.core.domain.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayerUseCase {

    fun getAllPlayer(): Flow<Resource<List<Player>>>

    fun getFavoritePlayer(): Flow<List<Player>>

    fun setFavoritePlayer(player: Player, state: Boolean)
}