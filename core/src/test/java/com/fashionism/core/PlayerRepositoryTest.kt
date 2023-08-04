package com.fashionism.core

import com.fashionism.core.data.PlayerRepository
import com.fashionism.core.data.Resource
import com.fashionism.core.data.source.local.LocalDataSource
import com.fashionism.core.data.source.local.entity.PlayerEntity
import com.fashionism.core.data.source.remote.RemoteDataSource
import com.fashionism.core.data.source.remote.network.APIResponse
import com.fashionism.core.utils.AppExecutors
import com.fashionism.core.utils.DataDummy
import com.fashionism.core.utils.DataMapper
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
class PlayerRepositoryTest {


    @Mock
    private lateinit var remoteDataSource: RemoteDataSource

    @Mock
    private lateinit var localDataSource: LocalDataSource

    @Mock
    private lateinit var appExecutors: AppExecutors

    private lateinit var playerRepository: PlayerRepository

    @Before
    fun setUp() {
        playerRepository = PlayerRepository(remoteDataSource, localDataSource, appExecutors)
    }

    @Test
    fun `make sure getAllPlayer() is not null`() = runBlocking {
        // Given
        val emptyList: List<PlayerEntity> = emptyList()
        val flowList = flowOf(emptyList)

        `when`(localDataSource.getAllPlayer()).thenReturn(flowList)
        //noinspection UnnecessaryStubbing
        `when`(remoteDataSource.getAllPlayer()).thenReturn(flowOf(APIResponse.Success(listOf())))

        // When
        val resultFlow = playerRepository.getAllPlayer()

        // Then
        assertNotNull(resultFlow)
    }

    @Test
    fun `make sure getAllPlayer() returns correct value`() = runBlocking {
        // Given
        val playerList = DataDummy.generateDummyPlayer()
        val flowList = flowOf(playerList)

        `when`(localDataSource.getAllPlayer()).thenReturn(flowList)
        `when`(remoteDataSource.getAllPlayer()).thenReturn(flow {
            APIResponse.Success(playerList)
        })

        // When
        val resultFlow = playerRepository.getAllPlayer()

        // Then
        resultFlow.collect { resource ->
            when (resource) {
                is Resource.Loading -> {
                    // Handle loading state if needed
                }
                is Resource.Success -> {
                    val data = resource.data
                    val playerListFromFlow = data?.map { DataMapper.mapDomainToEntity(it) }
                    // Perform assertions on the data
                    assertEquals(playerList[0], playerListFromFlow?.get(0))
                }
                is Resource.Error -> {
                    // Handle error state if needed
                }
            }
        }
    }


}