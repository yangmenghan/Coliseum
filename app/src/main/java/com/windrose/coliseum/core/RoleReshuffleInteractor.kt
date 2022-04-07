package com.windrose.coliseum.core

import com.windrose.coliseum.core.util.GetRandomElements
import com.windrose.coliseum.data.GameRepository
import com.windrose.coliseum.data.RoleRepository
import org.koin.core.annotation.Factory

@Factory
class RoleReshuffleInteractor constructor(
    private val gameRepository: GameRepository,
    private val roleRepository: RoleRepository,
    private val getRandomElements: GetRandomElements
) {

    fun reshuffle(playerIndex: Int) {
        val game = gameRepository.getCurrentGame()
        if (playerIndex < 0 || playerIndex > game.players.size) throw RuntimeException("Player index out of range")

        val currentRoles = game.players.map { it.role.id }
        val rolesId = roleRepository.getAvailableRolesIds()

        try {
            val newRoleId = getRandomElements.get(rolesId, currentRoles, 1)[0]
            val newRole = roleRepository.getRole(newRoleId) ?: return handleFailure()
            gameRepository.setPlayerRole(newRole, playerIndex)
        } catch (e: Exception) {
            return handleFailure()
        }
    }

    private fun handleFailure() {
        TODO("Not Implemented")
    }
}
