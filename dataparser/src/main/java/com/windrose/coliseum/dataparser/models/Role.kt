package com.windrose.coliseum.dataparser.models

data class Role(
    val name: String,
    val origin: String,
    val author: String? = null,
    val universe: String? = null,
    val powerMultiplier: Int? = null,
    val tags: List<Tag>? = null,
    val id: Int
)

data class Tag(val name: String)
