package org.kotlin.playground


/**
 * Loops,Ranges,
 * all this magic stuff that makes possible to hit stack overflow error
 */
fun main() {

    //Ranges
    val range = 1..10
    val range2 = 1..<10
    val evens = 2..10 step 2

    println(range)
    println(range2)
    println(evens)

    //finally maps and folds!
    val allEvensString = evens
        .map { it.toShort() }
        .fold("") { acc, el -> "$acc $el" }

    println(allEvensString)

    //For loops
    println("For loops")
    for (n in 1..5) {
        print(n)
    }
    println("\n---")

    //The same with collections
    val list = listOf("a", "b", "c")

    for (letter in list) {
        println(letter)
    }

    //While loops
    //With precondition
    println("While loops")
    var counter = 0
    //Might not execute code block based on precondition
    while (counter < 5) {
        println("Adding 1 to the counter")
        counter++
    }

    println("Counter is $counter")

    //With post condition
    do {
        println("I'm gonna doit anyway, at least once!")
        counter++
    } while (counter < 5)

}