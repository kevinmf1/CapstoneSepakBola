package com.fashionism.capstonesepakbola.di

import com.fashionism.core.domain.usecase.PlayerUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteDependencies {
    fun playerUseCase(): PlayerUseCase
}