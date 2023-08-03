package com.fashionism.core.di

import com.fashionism.core.data.PlayerRepository
import com.fashionism.core.domain.repository.IPlayerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
@Suppress("unused", "unused")
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(playerRepository: PlayerRepository): IPlayerRepository

}