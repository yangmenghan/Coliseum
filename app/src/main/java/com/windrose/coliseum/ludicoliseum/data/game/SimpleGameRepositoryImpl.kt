package com.windrose.coliseum.ludicoliseum.data.game

import com.windrose.coliseum.ludicoliseum.data.GameRepository
import com.windrose.coliseum.ludicoliseum.entity.Game

class SimpleGameRepositoryImpl : GameRepository {

    private var game = Game(listOf())

    override fun setCurrentGame(game: Game) {
        this.game = game
    }

    override fun getCurrentGame() = game

    override fun setCurrentPlayer(currentPlayer: Int) {
        game = game.copy(currentPlayer = currentPlayer)
    }

    override fun setPlayerAlive(alive: Boolean, index: Int) {
        val newPlayers = game.players.toMutableList()
        newPlayers[index] = newPlayers[index].copy(isAlive = alive)
        game = game.copy(players = newPlayers)
    }
}