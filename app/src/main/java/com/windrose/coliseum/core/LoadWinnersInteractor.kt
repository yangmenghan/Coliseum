package com.windrose.coliseum.core

import com.windrose.coliseum.data.GameRepository
import com.windrose.coliseum.entity.Player
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
