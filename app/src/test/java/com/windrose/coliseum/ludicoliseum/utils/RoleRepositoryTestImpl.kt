package com.windrose.coliseum.ludicoliseum.utils

import com.windrose.coliseum.dataparser.models.Role
import com.windrose.coliseum.ludicoliseum.data.RoleRepository

class RoleRepositoryTestImpl : RoleRepository {
    private val availableRoles = listOf(
        Role("Carapuce", "Pokémon", id = 0),
        Role("Salamèche", "Pokémon", id = 1),
        Role("Bulbizarre", "Pokémon", id = 2),
        Role("Pikachu", "Pokémon", id = 3),
        Role("Goupix", "Pokémon", id = 4),
        Role("Évoli", "Pokémon", id = 5)
    )

    override fun getAvailableRolesIds(): List<Int> =
        availableRoles.map { it.id }

    override fun getRole(roleId: Int): Role? =
        availableRoles.find { it.id == roleId }

    override fun getRoles(rolesIds: List<Int>): List<Role> =
        rolesIds.mapNotNull { getRole(it) }
}
