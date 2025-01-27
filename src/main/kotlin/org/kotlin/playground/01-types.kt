package org.kotlin.playground

fun main() {

    /**
     * This numeric types
     * Usual ones that we used to have everywhere.
     */

    //Int
    val i = 10
    //Long
    val l = 100L
    //Double
    val d = 19.99
    //Float
    val f = 20.23f

    println("i is ${i.javaClass.kotlin.simpleName}")
    println("l is ${l.javaClass.kotlin.simpleName}")
    println("d is ${d.javaClass.kotlin.simpleName}")
    println("f is ${f.javaClass.kotlin.simpleName}")

    println("---")
    val boolean = true
    val string = "Some string"
    val char = 'c'

    val unit = Unit //it's basically void type but with a hint of FP in naming

    println(boolean)
    println(string)
    println(char)
}