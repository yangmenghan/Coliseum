package com.windrose.coliseum.ludicoliseum.characters.models

data class Tag(val name: String) {
    val subTags: List<Tag> = ArrayList()
    fun addSubTag(tag: Tag) {

    }
}