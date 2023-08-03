package com.fashionism.capstonesepakbola.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fashionism.core.domain.usecase.PlayerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(playerUseCase: PlayerUseCase): ViewModel() {
    val player = playerUseCase.getAllPlayer().asLiveData()

}