package com.windrose.coliseum.ludicoliseum.data

import com.windrose.coliseum.dataparser.models.Role

interface RoleRepository {

    fun getRandomRoles(rolesNumber: Int): List<Role>
    fun getAvailableRolesId(): List<Int>
    fun getRole(roleId: Int): Role?
}
