package com.fashionism.capstonesepakbola.di

import com.fashionism.core.data.PlayerRepository
import com.fashionism.core.domain.usecase.PlayerInteractor
import com.fashionism.core.domain.usecase.PlayerUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsUseCase(playerRepository: PlayerRepository): PlayerUseCase=PlayerInteractor(playerRepository)
}