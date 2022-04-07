package com.windrose.coliseum.utils

import com.windrose.coliseum.dataparser.models.Role
import com.windrose.coliseum.data.RoleRepository

class RoleRepositoryTestImpl : RoleRepository {
    private val availableRoles = listOf(
        Role(id = 0, name = "Carapuce", origin = "Pokémon"),
        Role(id = 1, name = "Salamèche", origin = "Pokémon"),
        Role(id = 2, name = "Bulbizarre", origin = "Pokémon"),
        Role(id = 3, name = "Pikachu", origin = "Pokémon"),
        Role(id = 4, name = "Goupix", origin = "Pokémon"),
        Role(id = 5, name = "Évoli", origin = "Pokémon")
    )

    override fun getAvailableRolesIds(): List<Int> =
        availableRoles.map { it.id }

    override fun getRole(roleId: Int): Role? =
        availableRoles.find { it.id == roleId }

    override fun getRoles(rolesIds: List<Int>): List<Role> =
        rolesIds.mapNotNull { getRole(it) }
}
