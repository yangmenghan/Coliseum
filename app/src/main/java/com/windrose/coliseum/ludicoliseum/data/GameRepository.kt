package com.windrose.coliseum.ludicoliseum.data

import com.windrose.coliseum.dataparser.models.Role
import com.windrose.coliseum.ludicoliseum.entity.Game

interface GameRepository {
    fun setCurrentGame(game: Game)
    fun getCurrentGame(): Game
    fun setCurrentPlayer(currentPlayer: Int)
    fun setPlayerAlive(alive: Boolean, index: Int)
    fun setPlayerRole(newRole: Role, playerIndex: Int)
}
