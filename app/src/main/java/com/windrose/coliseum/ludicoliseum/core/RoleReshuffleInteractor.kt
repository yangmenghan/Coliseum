package com.windrose.coliseum.ludicoliseum.core

import com.windrose.coliseum.ludicoliseum.core.util.GetRandomElements
import com.windrose.coliseum.ludicoliseum.data.GameRepository
import com.windrose.coliseum.ludicoliseum.data.RoleRepository
import javax.inject.Inject

class RoleReshuffleInteractor @Inject constructor(
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
