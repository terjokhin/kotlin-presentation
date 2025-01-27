package org.kotlin.playground

/**
 * This is the main method. You don't even need a class to wrap it.
 */
fun main(){
    println("Hello World!")

    //Let's create a val! Val is immutable.
    var name = "Name!"
    //This is how string interpolation works.
    printName(name)

    name = Data.ALEXEY
    printName(name)
}

/**
 * It's a function that returns nothing.
 *
 * @property name name to print
 * @return Unit
 */
fun printName(name: String) {
    println("Is name $name an Alexey: ${areYouAlexey(name)}")
}

/**
 * It's a function that takes String nut returns Boolean
 * @property name name to check if it is an Alexey
 * @return true if name is Alexey, false otherwise
 */
fun areYouAlexey(name: String): Boolean {
    return name == Data.ALEXEY
}

object Data {
    const val ALEXEY = "Alexey"
}