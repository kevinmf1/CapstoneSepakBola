package com.fashionism.core.data

import com.fashionism.core.data.source.local.LocalDataSource
import com.fashionism.core.data.source.remote.RemoteDataSource
import com.fashionism.core.data.source.remote.network.APIResponse
import com.fashionism.core.data.source.remote.response.PlayerResponse
import com.fashionism.core.domain.model.Player
import com.fashionism.core.domain.repository.IPlayerRepository
import com.fashionism.core.utils.AppExecutors
import com.fashionism.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerRepository @Inject constructor (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IPlayerRepository {

    override fun getAllPlayer(): Flow<Resource<List<Player>>> =
        object : NetworkBoundResource<List<Player>, List<PlayerResponse>>() {

            override fun loadFromDB(): Flow<List<Player>> {
                return localDataSource.getAllPlayer().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Player>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<APIResponse<List<PlayerResponse>>> =
                remoteDataSource.getAllPlayer()

            override suspend fun saveCallResult(data: List<PlayerResponse>) {
                val playerList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertPlayer(playerList)
            }
        }.asFlow()

    override fun getPlayerByName(name: String): Flow<List<Player>> {
        return localDataSource.getPlayerByName(name).map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun getFavoritePlayer(): Flow<List<Player>> {
        return localDataSource.getFavoritePlayer().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoritePlayer(player: Player, state: Boolean) {
        val playerEntity = DataMapper.mapDomainToEntity(player)
        appExecutors.diskIO().execute { localDataSource.setFavoritePlayer(playerEntity, state) }
    }

}