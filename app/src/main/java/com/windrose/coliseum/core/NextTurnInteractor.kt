package com.windrose.coliseum.core

import com.windrose.coliseum.data.GameRepository
import com.windrose.coliseum.entity.Game
import org.koin.core.annotation.Factory

@Factory
class NextTurnInteractor constructor(private val gameRepository: GameRepository) {

    fun nextTurn() {
        val game = gameRepository.getCurrentGame()
        val nextTurn =
            game.currentPlayer.takeIf { it == Game.CURRENT_PLAYER_AT_GAME_END } ?: getNextAlivePlayerIndex(game)
        gameRepository.setCurrentPlayer(nextTurn)
    }

    private fun getNextAlivePlayerIndex(game: Game): Int {
        if (game.players.count { it.isAlive } <= 1) return Game.CURRENT_PLAYER_AT_GAME_END

        val offset = game.currentPlayer
        for (i in 1 until game.players.size) {
            val index = (offset + i) % game.players.size
            if (game.players[index].isAlive) return index
        }
        return Game.CURRENT_PLAYER_AT_GAME_END
    }
}
