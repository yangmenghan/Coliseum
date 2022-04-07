package com.windrose.coliseum.core

import com.windrose.coliseum.dataparser.models.Role
import com.windrose.coliseum.core.util.GetRandomElements
import com.windrose.coliseum.data.GameRepository
import com.windrose.coliseum.data.RoleRepository
import com.windrose.coliseum.entity.Game
import com.windrose.coliseum.entity.Player
import org.koin.core.annotation.Factory

@Factory
class CreateGameInteractor constructor(
    private val gameRepository: GameRepository,
    private val roleRepository: RoleRepository,
    private val getRandomElements: GetRandomElements
) {

    fun create(playerNumber: Int) {
        val randomRoles = getRandomRoles(playerNumber)
        val game = Game(randomRoles.map { Player(it) })
        gameRepository.setCurrentGame(game)
    }

    private fun getRandomRoles(playerNumber: Int): List<Role> {
        val availableRoleIds = roleRepository.getAvailableRolesIds()
        val rolesIds = getRandomElements.get(availableRoleIds, listOf(), playerNumber)
        return roleRepository.getRoles(rolesIds)
    }
}
