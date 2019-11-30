package com.windrose.coliseum.ludicoliseum.data

import com.windrose.coliseum.dataparser.models.Role

interface RoleRepository {
    fun getAvailableRolesIds(): List<Int>
    fun getRole(roleId: Int): Role?
    fun getRoles(rolesIds: List<Int>): List<Role>
}
