package com.windrose.coliseum.ludicoliseum.core

import com.windrose.coliseum.dataparser.models.Role
import com.windrose.coliseum.ludicoliseum.entity.Game
import com.windrose.coliseum.ludicoliseum.entity.Player

class CreateGameInteractor {

    fun create(playerNumber : Int): Game {
        return Game((0 until playerNumber).map { generateRandomPlayer(it) })
    }

    private fun generateRandomPlayer(it: Int) = Player(Role("ID: $it"))
}