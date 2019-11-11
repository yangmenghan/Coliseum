package com.windrose.coliseum.dataparser.models

data class Role(
    val name: String,
    val tags: List<Tag>? = null,
    val powerMultiplier: Int = 0,
    val origin: String? = null,
    val author: String? = null,
    val universe: String? = null,
    val index: Int? = -1
)

data class Tag(val name: String)