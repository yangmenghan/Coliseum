package games.windrose.coliseum.entity

import games.windrose.coliseum.dataparser.models.Role

data class Game(val players: List<Player>, val currentPlayer: Int = 0){

    companion object{
        const val CURRENT_PLAYER_AT_GAME_END = -1
    }
}

data class Player(val role: Role, val isAlive: Boolean = true)
