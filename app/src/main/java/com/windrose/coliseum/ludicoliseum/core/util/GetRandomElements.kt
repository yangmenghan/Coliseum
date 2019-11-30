package com.windrose.coliseum.ludicoliseum.core.util

import java.util.Random
import javax.inject.Inject

class GetRandomElements @Inject constructor() {

    fun <T> get(elements: List<T>, elementsToExclude: List<T>, resultSize: Int): List<T> {
        checkArgumentValidity(elements, elementsToExclude, resultSize)
        val excludedIndexes = elementsToExclude.map { elements.indexOf(it) }
        return getIndexes(elements.size, excludedIndexes, resultSize).map { elements[it] }
    }

    private fun <T> checkArgumentValidity(elements: List<T>, elementsToExclude: List<T>, resultSize: Int) {
        val actualSize = elements.filter { !elementsToExclude.contains(it) }.size
        if (elements.size - elementsToExclude.size < resultSize) {
            throw RuntimeException(
                "Elements list too small. Result size : $resultSize, elements number after exclusion: $actualSize"
            )
        }
    }

    private fun getIndexes(maxIndex: Int, indexToExclude: List<Int>, resultSize: Int): Set<Int> {
        val indexSet = mutableSetOf<Int>()
        val random = Random()
        while (indexSet.size < resultSize) {
            random.nextInt(maxIndex).takeUnless { indexToExclude.contains(it) }?.let { indexSet.add(it) }
        }
        return indexSet
    }
}
