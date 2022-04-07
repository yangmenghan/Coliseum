package com.windrose.coliseum.core.util

import org.junit.Assert
import org.junit.Test

class GetRandomElementsTest {

    private val getRandomElements = GetRandomElements()

    @Test
    fun result_has_distinct_elements() {
        val elements = listOf("A", "B", "C", "D")
        val elementsToExclude = listOf<String>()
        val result = getRandomElements.get(elements, elementsToExclude, 2)

        Assert.assertEquals(result.size, result.distinct().size)
    }

    @Test
    fun result_has_right_size() {
        val elements = listOf("A", "B", "C", "D", "E")
        val elementsToExclude = listOf<String>()
        val result = getRandomElements.get(elements, elementsToExclude, 3)

        Assert.assertEquals(3, result.size)
    }

    @Test
    fun elements_are_excluded() {
        val elements = listOf("A", "B", "C", "D", "E")
        val elementsToExclude = listOf("C", "D")
        val result = getRandomElements.get(elements, elementsToExclude, 3)

        elementsToExclude.forEach { Assert.assertFalse(result.contains(it)) }
    }

    @Test
    fun can_return_empty_list() {
        val elements = listOf("A", "B", "C", "D", "E")
        val elementsToExclude = listOf<String>()
        val result = getRandomElements.get(elements, elementsToExclude, 0)

        Assert.assertEquals(result, listOf<String>())
    }

    @Test(expected = Exception::class)
    fun throw_error_if_too_few_elements_before_excluding() {
        val elements = listOf("A", "B", "C", "D", "E")
        val elementsToExclude = listOf("C", "D")
        val result = getRandomElements.get(elements, elementsToExclude, 6)

        elementsToExclude.forEach { Assert.assertFalse(result.contains(it)) }
    }

    @Test(expected = Exception::class)
    fun throw_error_if_too_few_element_after_excluding() {
        val elements = listOf("A", "B", "C", "D", "E")
        val elementsToExclude = listOf("C", "D")
        val result = getRandomElements.get(elements, elementsToExclude, 4)

        elementsToExclude.forEach { Assert.assertFalse(result.contains(it)) }
    }
}
