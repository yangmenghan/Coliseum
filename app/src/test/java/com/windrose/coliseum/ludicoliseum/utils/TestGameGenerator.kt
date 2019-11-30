package com.windrose.coliseum.ludicoliseum.utils

import com.windrose.coliseum.dataparser.models.Role
import com.windrose.coliseum.ludicoliseum.entity.Game
import com.windrose.coliseum.ludicoliseum.entity.Player

object TestGameGenerator {

    fun generate(aliveStatus: List<Boolean>, currentPlayer: Int = 0) = Game(aliveStatus.mapIndexed { index, isAlive ->
        Player(role = Role(id = index, name = "test", origin = "Test Origin"), isAlive = isAlive)
    }, currentPlayer)
}
