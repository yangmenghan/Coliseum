package com.windrose.coliseum.ludicoliseum.data

import android.content.Context
import com.windrose.coliseum.dataparser.CharacterDataParserImpl
import com.windrose.coliseum.dataparser.models.Role
import java.util.*
import javax.inject.Inject

//TODO : Context shouldn't be here
class RoleRepositoryImpl @Inject constructor(context: Context) : RoleRepository {

    private val availableRoles: List<Role> = loadRoles(context)

    private fun loadRoles(context: Context): List<Role> {
        val stream = context.assets.open("characters.csv")
        return CharacterDataParserImpl().parseDataInputStream(stream)
    }

    override fun getRandomRoles(rolesNumber: Int): List<Role> {
        val indexSet = mutableSetOf<Int>()
        val random = Random()
        while (indexSet.size < rolesNumber) {
            indexSet.add(random.nextInt(availableRoles.size))
        }
        return indexSet.map { availableRoles[it] }.toList()
    }
}