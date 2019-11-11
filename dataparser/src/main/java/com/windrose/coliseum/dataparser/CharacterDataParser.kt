package com.windrose.coliseum.dataparser

import com.windrose.coliseum.dataparser.models.Role
import java.io.File

interface CharacterDataParser {
    fun parseDataFile(file: File): List<Role>?
}
