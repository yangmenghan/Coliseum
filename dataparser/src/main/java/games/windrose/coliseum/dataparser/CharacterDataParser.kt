package games.windrose.coliseum.dataparser

import games.windrose.coliseum.dataparser.models.Role
import java.io.File
import java.io.InputStream

interface CharacterDataParser {
    fun parseDataFile(file: File): List<Role>?
    fun parseDataInputStream(stream: InputStream): List<Role>
}
