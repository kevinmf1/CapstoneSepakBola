package com.fashionism.core.data.source.remote

import android.util.Log
import com.fashionism.core.data.source.remote.network.APIResponse
import com.fashionism.core.data.source.remote.network.APIService
import com.fashionism.core.data.source.remote.response.PlayerResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Suppress("unused", "unused")
class RemoteDataSource @Inject constructor(private val apiService: APIService) {

    suspend fun getAllPlayer(): Flow<APIResponse<List<PlayerResponse>>> {

        // get data from remote api
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.data
                if (dataArray.isNotEmpty()) {
                    emit(APIResponse.Success(response.data))
                } else {
                    emit(APIResponse.Empty)
                }
            } catch (e: Exception) {
                emit(APIResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}