package com.fashionism.core.data.source.local.room

import androidx.room.*
import com.fashionism.core.data.source.local.entity.PlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Query("SELECT * FROM player")
    fun getAllPlayer(): Flow<List<PlayerEntity>>

    @Query("SELECT * FROM player where isFavorite = 1")
    fun getFavoritePlayer(): Flow<List<PlayerEntity>>

    @Query("SELECT * FROM player where idPlayer = :idPlayer")
    fun getPlayerById(idPlayer: String): Flow<PlayerEntity>

    @Query("SELECT * FROM player WHERE LOWER(name) LIKE '%' || LOWER(:name) || '%'")
    fun getPlayerByName(name: String): Flow<List<PlayerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: List<PlayerEntity>)

    @Update
    fun updateFavoritePlayer(player: PlayerEntity)
}