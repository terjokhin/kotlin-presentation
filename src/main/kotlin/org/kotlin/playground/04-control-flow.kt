package org.kotlin.playground

/**
 * Usual control flow stuff like if/else, switch.
 * But with a twist.
 */
fun main() {
    /**
     * Simple if/else
     */
    val condition = true
    val randomString = "hi"

    if (condition) {
        println(randomString)
    } else {
        println("Condition is false")
    }

    //no ternary operator in Kotlin, but if/else is an expression

    println("And here is expression version")
    val result = if (condition) randomString else "nope"
    println(result)

    //Compiler won't let us do that
    // val anotherResult = if (condition) randomString

    //Interesting. Acts weird.
    val result2 = if (condition) randomString else 29.99
    println(result2.javaClass.kotlin.simpleName)


    /**
     * Now when construction
     */

    val anotherObj = "1"

    when (anotherObj) {
        "1" -> println("Hi there")
        "2" -> println("Oops")
        else -> println("Unknown")
    }

    //Also could be used as an expression
    //And also type derivation of the result is questionable.
    val whatToPrint = when (anotherObj) {
        "1" -> "How are you?"
        else -> 1
    }

    println(whatToPrint)
    println(whatToPrint.javaClass.kotlin.simpleName)

    /**
     * And some hybrid if/when thing
     */

    val randomValue = 50

    val resultOfSomething = when {
        randomValue < 50 -> "not enough"
        randomValue == 50 -> "jut on point"
        randomValue > 50 -> "better"
        else -> "not sure"
    }

    println(resultOfSomething)
}