package com.windrose.coliseum.dataparser

import com.windrose.coliseum.dataparser.models.*

interface CharacterDataParser{
    fun parseDataFile() : List<Character>?
}
