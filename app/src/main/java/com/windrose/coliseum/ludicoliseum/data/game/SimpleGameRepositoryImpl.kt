package com.windrose.coliseum.ludicoliseum.data.game

import com.windrose.coliseum.dataparser.models.Role
import com.windrose.coliseum.ludicoliseum.data.GameRepository
import com.windrose.coliseum.ludicoliseum.entity.Game
import javax.inject.Inject

class SimpleGameRepositoryImpl @Inject constructor() : GameRepository {

    // TODO : Use mutable model here
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

    override fun setPlayerRole(role: Role, index: Int) {
        val newPlayers = game.players.toMutableList()
        newPlayers[index] = newPlayers[index].copy(role = role)
        game = game.copy(players = newPlayers)
    }
}
