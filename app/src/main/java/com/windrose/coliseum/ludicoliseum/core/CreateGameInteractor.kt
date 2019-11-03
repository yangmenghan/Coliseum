package com.windrose.coliseum.ludicoliseum.core

import com.windrose.coliseum.dataparser.models.Role
import com.windrose.coliseum.ludicoliseum.data.GameRepository
import com.windrose.coliseum.ludicoliseum.entity.Game
import com.windrose.coliseum.ludicoliseum.entity.Player

class CreateGameInteractor(private val gameRepository: GameRepository) {

    fun create(playerNumber: Int) {
        val game =  Game((0 until playerNumber).map { generateRandomPlayer(it) })
        gameRepository.setCurrentGame(game)
    }

    private fun generateRandomPlayer(it: Int) = Player(Role("ID: $it"))
}