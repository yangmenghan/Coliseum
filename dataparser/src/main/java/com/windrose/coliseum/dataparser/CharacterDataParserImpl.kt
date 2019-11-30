package com.windrose.coliseum.dataparser

import com.windrose.coliseum.dataparser.models.Role
import com.windrose.coliseum.dataparser.models.Tag
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader

class CharacterDataParserImpl : CharacterDataParser {
    override fun parseDataFile(file: File): List<Role> =
        file.readLines().mapIndexedNotNull { index, line -> parseLine(line, index) }

    override fun parseDataInputStream(stream: InputStream): List<Role> =
        BufferedReader(InputStreamReader(stream))
            .lineSequence()
            .mapIndexedNotNull { index, line -> parseLine(line, index) }
            .toList()

    // ex of line :
    // A Comme Association;Jasper;A Comme Association;L'Homme;0;Fantastique;default;
    // TODO : Set to private
    fun parseLine(line: String, index: Int): Role? {
        val fields = line.split(FIELD_SEPARATOR)
        return if (fields.size < 2) {
            null
        } else {
            Role(
                id = index,
                origin = fields[0],
                name = fields[1],
                universe = fields[2],
                author = fields[3],
                powerMultiplier = fields[4].toIntOrNull(),
                tags = fields.subList(5, fields.size).map { Tag(it) }
            )
        }
    }

    companion object {
        private const val FIELD_SEPARATOR = ";"
    }
}
