package com.windrose.coliseum.ludicoliseum.entity

import com.windrose.coliseum.dataparser.models.Role

data class Game(val players: List<Player>, var currentPlayer: Int = 0)

data class Player(val character: Role, val isAlive: Boolean = true)