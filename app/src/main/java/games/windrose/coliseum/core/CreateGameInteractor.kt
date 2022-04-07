package games.windrose.coliseum.core

import games.windrose.coliseum.dataparser.models.Role
import games.windrose.coliseum.core.util.GetRandomElements
import games.windrose.coliseum.data.GameRepository
import games.windrose.coliseum.data.RoleRepository
import games.windrose.coliseum.entity.Game
import games.windrose.coliseum.entity.Player
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
