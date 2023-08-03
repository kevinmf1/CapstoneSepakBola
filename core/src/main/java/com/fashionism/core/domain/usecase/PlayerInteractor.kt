package com.fashionism.core.domain.usecase

import com.fashionism.core.domain.model.Player
import com.fashionism.core.domain.repository.IPlayerRepository
import javax.inject.Inject

class PlayerInteractor @Inject constructor (private val playerRepository: IPlayerRepository) : PlayerUseCase {

    override fun getAllPlayer() = playerRepository.getAllPlayer()

    override fun getFavoritePlayer() = playerRepository.getFavoritePlayer()

    override fun setFavoritePlayer(player: Player, state: Boolean) = playerRepository.setFavoritePlayer(player, state)
}