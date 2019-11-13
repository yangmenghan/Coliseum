package com.windrose.coliseum.dataparser

import com.windrose.coliseum.dataparser.models.Role
import com.windrose.coliseum.dataparser.models.Tag
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader

class CharacterDataParserImpl : CharacterDataParser {
    override fun parseDataFile(file: File): List<Role> =
        file.readLines().mapNotNull { parseLine(it) }

    override fun parseDataInputStream(stream: InputStream): List<Role> =
        BufferedReader(InputStreamReader(stream)).lineSequence().mapNotNull { parseLine(it) }.toList()

    // ex of line :
    // 5;Bjorn;Bottero;Ewilan;Ewilan;0;Fantasy;Inconnu;
    // TODO : Set to private
    fun parseLine(line: String): Role? {
        val fields = line.split(FIELD_SEPARATOR)
        return if (fields.size < 6) {
            null
        } else {
            Role(
                index = fields[0].toInt(),
                name = fields[1],
                author = fields[2],
                origin = fields[3],
                universe = fields[4],
                powerMultiplier = fields[5].toInt(),
                tags = fields.subList(6, fields.size).map { Tag(it) }
            )
        }
    }

    companion object {
        private const val FIELD_SEPARATOR = ";"
    }
}