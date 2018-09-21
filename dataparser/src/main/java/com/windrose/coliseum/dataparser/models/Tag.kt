package com.windrose.coliseum.dataparser.models

import java.util.ArrayList

data class Tag(val name: String) {
    val subTags: List<Tag> = ArrayList()
    fun addSubTag(tag: Tag) {

    }
}