package games.windrose.coliseum.data

import games.windrose.coliseum.dataparser.models.Role

interface RoleRepository {
    fun getAvailableRolesIds(): List<Int>
    fun getRole(roleId: Int): Role?
    fun getRoles(rolesIds: List<Int>): List<Role>
}
