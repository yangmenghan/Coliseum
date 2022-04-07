package com.windrose.coliseum.data.game

import com.windrose.coliseum.dataparser.models.Role
import com.windrose.coliseum.data.GameRepository
import com.windrose.coliseum.entity.Game
import org.koin.core.annotation.Single

@Single
class SimpleGameRepositoryImpl : GameRepository {

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
