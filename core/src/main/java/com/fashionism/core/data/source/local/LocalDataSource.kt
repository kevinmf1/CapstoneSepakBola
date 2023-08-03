package com.fashionism.core.data.source.local

import com.fashionism.core.data.source.local.entity.PlayerEntity
import com.fashionism.core.data.source.local.room.PlayerDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Suppress("unused", "unused")
class LocalDataSource @Inject constructor(private val playerDao: PlayerDao) {

    fun getAllPlayer(): Flow<List<PlayerEntity>> = playerDao.getAllPlayer()

    fun getFavoritePlayer(): Flow<List<PlayerEntity>> = playerDao.getFavoritePlayer()

    fun getPlayerById(idPlayer: String) = playerDao.getPlayerById(idPlayer)

    fun getPlayerByName(name: String): Flow<List<PlayerEntity>> = playerDao.getPlayerByName(name)

    suspend fun insertPlayer(playerList: List<PlayerEntity>) = playerDao.insertPlayer(playerList)

    fun setFavoritePlayer(player: PlayerEntity, newState: Boolean) {
        player.isFavorite = newState
        playerDao.updateFavoritePlayer(player)
    }
}