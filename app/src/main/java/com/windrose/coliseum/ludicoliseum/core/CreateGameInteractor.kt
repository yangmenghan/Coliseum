package com.windrose.coliseum.ludicoliseum.core

import com.windrose.coliseum.ludicoliseum.data.GameRepository
import com.windrose.coliseum.ludicoliseum.data.RoleRepository
import com.windrose.coliseum.ludicoliseum.entity.Game
import com.windrose.coliseum.ludicoliseum.entity.Player
import javax.inject.Inject

class CreateGameInteractor @Inject constructor(
    private val gameRepository: GameRepository,
    private val roleRepository: RoleRepository
) {

    fun create(playerNumber: Int) {
        val randomRoles = roleRepository.getRandomRoles(playerNumber)
        val game = Game(randomRoles.map { Player(it) })
        gameRepository.setCurrentGame(game)
    }
}