package com.windrose.coliseum.dataparser.models

data class Role(val name: String, val tags: List<Tag>? = null, val origin: String? = null)