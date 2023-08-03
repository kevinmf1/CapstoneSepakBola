package com.fashionism.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fashionism.core.domain.usecase.PlayerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(playerUseCase: PlayerUseCase) : ViewModel() {
    val favoritePlayer = playerUseCase.getFavoritePlayer().asLiveData()
}