package games.windrose.coliseum.data

import games.windrose.coliseum.dataparser.models.Role
import games.windrose.coliseum.entity.Game

interface GameRepository {
    fun setCurrentGame(game: Game)
    fun getCurrentGame(): Game
    fun setCurrentPlayer(currentPlayer: Int)
    fun setPlayerAlive(alive: Boolean, index: Int)
    fun setPlayerRole(newRole: Role, playerIndex: Int)
}
