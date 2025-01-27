package org.kotlin.playground

/**
 * There are 3 main types of collections in Kotlin
 *
 * 1. List - ordered collection of items
 * 2. Sets - unordered collection of unique elements
 * 3. Maps - sets of key-value pairs,
 *           where key is unique and can have only 1 value bound
 *
 * All these collections could be immutable and mutable.
 */
fun main() {


    //Lists
    val immutableList = listOf(1, 2, 3, 4, 5)
    println(immutableList)

    val mutableList = mutableListOf(1, 2, 3, 4, 5)
    mutableList.addAll(immutableList)
    mutableList.add(99)
    println(mutableList)

    val immutableAgain: List<Int> = mutableList

    //Sets
    val immutableSet = setOf(1, 2, 3, 4, 5)
    println(immutableSet)

    val mutableSet = mutableSetOf(2, 3, 4, 5, 6)
    mutableSet.addAll(immutableSet)
    println(mutableSet)

    //Maps
    val immutableMap = mapOf(1 to "one", 2 to "two", 3 to "three")

    val map: Map<Int, String> = mapOf()
    println(immutableMap)

    println(immutableMap[8] ?: "nothing")

    val mutableMap = mutableMapOf(1 to "one", 2 to "two", 4 to "four")
    mutableMap.putAll(immutableMap)
    println(mutableMap)

}