package com.windrose.coliseum.ludicoliseum.entity

import com.windrose.coliseum.dataparser.models.Role

data class Game(val players: List<Player>, val currentPlayer: Int = 0){

    companion object{
        const val CURRENT_PLAYER_AT_GAME_END = -1
    }
}

data class Player(val character: Role, val isAlive: Boolean = true)