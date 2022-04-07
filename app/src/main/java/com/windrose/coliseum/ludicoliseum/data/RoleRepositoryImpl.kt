package com.windrose.coliseum.ludicoliseum.data

import android.content.Context
import com.windrose.coliseum.dataparser.CharacterDataParserImpl
import com.windrose.coliseum.dataparser.models.Role
import org.koin.core.annotation.Single

//TODO : Context shouldn't be here
@Single
class RoleRepositoryImpl(context: Context) : RoleRepository {

    private val availableRoles: List<Role> = loadRoles(context)

    private fun loadRoles(context: Context): List<Role> {
        val stream = context.assets.open("characters.csv")
        return CharacterDataParserImpl().parseDataInputStream(stream)
    }


    override fun getAvailableRolesIds(): List<Int> = availableRoles.map { it.id }

    override fun getRole(roleId: Int): Role? =
        availableRoles.find { it.id == roleId }

    override fun getRoles(rolesIds: List<Int>): List<Role> =
        // TODO : Handle null values here
        rolesIds.mapNotNull { getRole(it) }
}
