package com.fashionism.capstonesepakbola.detail

import androidx.lifecycle.ViewModel
import com.fashionism.core.domain.model.Player
import com.fashionism.core.domain.usecase.PlayerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val playerUseCase: PlayerUseCase) : ViewModel() {
    fun setFavoritePlayer(player: Player, newStatus:Boolean) =
        playerUseCase.setFavoritePlayer(player, newStatus)
}