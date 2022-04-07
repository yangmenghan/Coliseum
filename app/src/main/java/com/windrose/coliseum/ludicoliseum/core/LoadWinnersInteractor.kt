package com.windrose.coliseum.ludicoliseum.core

import com.windrose.coliseum.ludicoliseum.data.GameRepository
import com.windrose.coliseum.ludicoliseum.entity.Player
import org.koin.core.annotation.Factory

@Factory
class LoadWinnersInteractor constructor(
    private val gameRepository: GameRepository
) {

    fun load(): List<Player> {
        val game = gameRepository.getCurrentGame()
        return game.players.filter { it.isAlive }
    }
}
