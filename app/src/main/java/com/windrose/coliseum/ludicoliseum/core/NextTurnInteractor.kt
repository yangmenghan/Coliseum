package com.windrose.coliseum.ludicoliseum.core

import com.windrose.coliseum.ludicoliseum.data.GameRepository
import com.windrose.coliseum.ludicoliseum.entity.Game
import javax.inject.Inject

class NextTurnInteractor @Inject constructor(private val gameRepository: GameRepository) {

    fun nextTurn() {
        val game = gameRepository.getCurrentGame()
        val nextTurn =
            game.currentPlayer.takeIf { it == Game.CURRENT_PLAYER_AT_GAME_END } ?: getNextAlivePlayerIndex(game)
        gameRepository.setCurrentPlayer(nextTurn)
    }

    private fun getNextAlivePlayerIndex(game: Game): Int {
        val offset = game.currentPlayer
        for (i in 1 until game.players.size) {
            val index = (offset + i) % game.players.size
            if (game.players[index].isAlive) return index
        }
        return Game.CURRENT_PLAYER_AT_GAME_END
    }
}
