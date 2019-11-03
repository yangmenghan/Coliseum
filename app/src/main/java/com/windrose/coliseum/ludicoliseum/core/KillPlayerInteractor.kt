package com.windrose.coliseum.ludicoliseum.core

import com.windrose.coliseum.ludicoliseum.data.GameRepository
import javax.inject.Inject

class KillPlayerInteractor @Inject constructor(private val gameRepository: GameRepository) {

    fun kill(playerIndex: Int) {
        val game = gameRepository.getCurrentGame()
        if (playerIndex < 0 || playerIndex >= game.players.size) return
        gameRepository.setPlayerAlive(false, playerIndex)
    }
}